package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {
    private static final Long ID = 1L;
    private static final String RECIPENOTE = "recipeNotes";

    NotesCommandToNotes converter;

    @Before
    public void setUp(){

        converter = new NotesCommandToNotes();
    }

    @Test
    public void nullTestObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void emptyTestObject(){
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void converter(){
        //given

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(RECIPENOTE);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(RECIPENOTE, notes.getRecipeNotes());
    }
}
