package Objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 20.11.2017.
 */
public class WordDictionTest {
    WordDiction wordDiction = new WordDiction();
    @Test
    public void getId() throws Exception {
        wordDiction.setId(1);
        assertTrue(1 == wordDiction.getId());

    }

    @Test
    public void getWord() throws Exception {
    wordDiction.setWord("Word");
    assertEquals("Word", wordDiction.getWord());


    }

    @Test
    public void getDetermination() throws Exception {
        wordDiction.setDetermination("Determination");
        assertEquals("Determination", wordDiction.getDetermination());

    }

}