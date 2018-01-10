package Objects;



import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 20.11.2017.
 */
public class SurveyTest {
    Survey survey = new Survey();
    @Test
    public void getSounding() throws Exception {
    survey.setSounding("gruz");
    assertEquals("gruz", survey.getSounding());

    }

    @Test
    public void setSounding() throws Exception {

    }

    @Test
    public void getVolume() throws Exception {
        survey.setVolume(200);
        assertTrue(200 == survey.getVolume());
    }

    @Test
    public void setVolume() throws Exception {

    }

    @Test
    public void getDensity() throws Exception {
        survey.setDensity(200);
        assertTrue(200 ==  survey.getDensity());
    }

    @Test
    public void setDensity() throws Exception {

    }

    @Test
    public void getTonnes() throws Exception {
        survey.setTonnes(200);
        assertTrue(200 ==  survey.getTonnes());
    }

    @Test
    public void setTonnes() throws Exception {

    }

}