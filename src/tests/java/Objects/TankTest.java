package Objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 20.11.2017.
 */
public class TankTest {
    Tank tank = new Tank();
    @Test
    public void getTankName() throws Exception {
        tank.setTankName("asd");
        assertEquals("asd",tank.getTankName());
    }

    @Test
    public void setTankName() throws Exception {

    }

    @Test
    public void getTankCopacity() throws Exception {
    tank.setTankCopacity(200.0);
    assertTrue(200.0==tank.getTankCopacity());
    }

    @Test
    public void setTankCopacity() throws Exception {

    }

}