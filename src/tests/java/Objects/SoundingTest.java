package Objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 20.11.2017.
 */
public class SoundingTest {
    Sounding sounding = new Sounding();
    @Test
    public void getSounding() throws Exception {
        sounding.setSounding("Sounding");
        assertEquals("Sounding", sounding.getSounding());

    }

    @Test
    public void getTonnes() throws Exception {
        sounding.setTonnes(200);
        assertTrue(200 == sounding.getTonnes());
    }

}