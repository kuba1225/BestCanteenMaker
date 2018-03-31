
import dynamicstructures.Coordinates;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class CoordinatesTest {

    @Test
    public void methodsTest() {
        Coordinates c = new Coordinates(2, 3);

        assertEquals(c.getX(), 2);
        assertEquals(c.getY(), 3);

        c.setX(4);
        c.setY(5);

        assertEquals(c.getX(), 4);
        assertEquals(c.getY(), 5);
    }
}
