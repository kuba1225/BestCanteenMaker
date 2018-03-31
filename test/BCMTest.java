
import logic.BCM;
import static logic.BCM.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Kuba
 */
public class BCMTest {

    @Test
    public void bcmGenerateProjectMethodTest() {
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

        bcm.generateProjects();
        assertNotNull(bcm.getBestIndividualInEachIterationPopulation());
    }

    @Test
    public void testOfDifferentCoordinatesToGeneratePopulation() {
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

        bcm.generateProjects();
        assertNotNull(bcm.getBestIndividualInEachIterationPopulation());
    }

}
