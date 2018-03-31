
import logic.Population;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class PopulationTest {

    @Test
    public void setPopulaitonTest() {
        Population p = new Population(100);
        assertEquals(p.individualsPopulationSize(),0);//liczba osobnikó przed ich wygenerowaniem to 0 - bo lista jest pusta
    }
}
