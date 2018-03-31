
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
public class IndividualTest {

    @Test
    public void initiationTest() {
        Individual i = new Individual();
        assertEquals(i.getLampsCoordinates().size(),0);
        assertEquals(i.getWindowsCoordinates().size(),0);
        assertEquals(i.getSeatsCoordinates().size(),0);
        assertEquals(i.getTablesCoordinates().size(),0);
    }
    
    @Test
    public void coordinatesArraysTest(){
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
        
        ic.setLighting(i, 1, 2);
        
        assertTrue(i.getLampsCoordinates().size()>0);
    }
}
