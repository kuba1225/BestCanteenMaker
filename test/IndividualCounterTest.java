
import logic.BCM;
import static logic.BCM.*;
import logic.Individual;
import logic.IndividualCounter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class IndividualCounterTest {

    @Test
    public void generationTest() {
        BCM bcm = new BCM();

        setA(10);
        setB(8);
        setC(3);
        setD(12);
        setE(7);
        setF(20);

        setBudget(50000);
        setCapacity(20);

        setHybrydizationFactor(0.5);
        setMutationFactor(0.5);

        setIterations(100);
        setNumberOfIndividualsInIteration(100);
        Individual i = new Individual();
        IndividualCounter ic = new IndividualCounter();

        ic.generateIndividual(i);

        assertTrue(i.getLampsCoordinates().size() > 0);
        assertTrue(i.getSeatsCoordinates().size() > 0);
        assertTrue(i.getWindowsCoordinates().size() > 0);
        assertTrue(i.getTablesCoordinates().size() > 0);

        assertTrue(i.getCostSum() > 0);

    }

    @Test
    public void restaurantComponentInitiationTest() {
        BCM bcm = new BCM();

        setA(10);
        setB(8);
        setC(3);
        setD(12);
        setE(7);
        setF(20);

        setBudget(50000);
        setCapacity(20);

        setHybrydizationFactor(0.5);
        setMutationFactor(0.5);

        setIterations(100);
        setNumberOfIndividualsInIteration(100);
        Individual i = new Individual();
        IndividualCounter ic = new IndividualCounter();

        ic.generateIndividual(i);

        assertNotNull(ic.getDoors());
        assertNotNull(ic.getLamps());
        assertNotNull(ic.getSeats());
        assertNotNull(ic.getShops());
        assertNotNull(ic.getWindows());
        assertNotNull(ic.getTables());

    }

    @Test
    public void settingObjectMethodTests() {
        BCM bcm = new BCM();

        setA(10);
        setB(8);
        setC(3);
        setD(12);
        setE(7);
        setF(20);

        setBudget(50000);
        setCapacity(20);

        setHybrydizationFactor(0.5);
        setMutationFactor(0.5);

        setIterations(100);
        setNumberOfIndividualsInIteration(100);
        Individual i = new Individual();
        IndividualCounter ic = new IndividualCounter();

        ic.generateIndividual(i);

        assertNotNull(ic.setDoor(i));
        assertNotNull(ic.setLighting(i, 2, 2));
        assertNotNull(ic.setRandomTablesAndSeats(i));
        assertNotNull(ic.setShop(i));
        assertNotNull(ic.setWindows(i, 1.5, ic.getWindows()[0]));

    }
}
