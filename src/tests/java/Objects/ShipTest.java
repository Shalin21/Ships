package Objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 20.11.2017.
 */
public class ShipTest {

    Ship ship = new Ship();

    @Test
    public void getShipId() throws Exception {
        ship.setShipId(1);
        assertTrue(1==ship.getShipId());
    }

    @Test
    public void getName() throws Exception {
        ship.setName("Name");
        assertEquals("Name", ship.getName());
    }

    @Test
    public void getType() throws Exception {
        ship.setType("Type");
        assertEquals("Type", ship.getType());
    }

    @Test
    public void getYear() throws Exception {
        ship.setYear(2000);
        assertTrue(2000 == ship.getYear());
    }

    @Test
    public void getLength() throws Exception {
        ship.setLength(200.0);
        assertTrue(200.0 == ship.getLength());
    }

    @Test
    public void getWidth() throws Exception {
        ship.setWidth(200.0);
        assertTrue(200.0== ship.getWidth());
    }

    @Test
    public void getEqpWeight() throws Exception {
        ship.setEqpWeight(200);
        assertTrue(200==ship.getEqpWeight());
    }

    @Test
    public void getMaxSeaguage() throws Exception {
        ship.setMaxSeaguage(20.0);
        assertTrue(20.0 == ship.getMaxSeaguage());
    }

    @Test
    public void getMaxCarrying() throws Exception {
        ship.setMaxCarrying(2000);
        assertTrue(2000 == ship.getMaxCarrying());
    }

    @Test
    public void getFlag() throws Exception {
        ship.setFlag("Flag");
        assertEquals("Flag", ship.getFlag());
    }

}