
import canteencomponents.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class CanteenComponentsTest {

    @Test
    public void accessMethodsTest() {
        Door door = new Door(1, 2, 2, 1, 100, 1);
        Shop shop = new Shop(1, 2, 2, 1, 100, 1);
        Table t = new Table(1, 1, 150, 1);
        Seat s = new Seat(75, 1);
        Lamp l = new Lamp(150, 1);
        Window w = new Window(0.75, 500, 1);

        assertEquals(2, (int) door.getLength());
        assertEquals(1, (int) shop.getX());
        assertEquals(150, (int) t.getPrice());
        assertEquals(75, (int) s.getPrice());
        assertEquals(150, (int) l.getPrice());
        assertEquals(500, (int) w.getPrice());

    }
}
