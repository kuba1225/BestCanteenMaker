
import logic.BCM;
import static logic.BCM.setA;
import static logic.BCM.setB;
import static logic.BCM.setBudget;
import static logic.BCM.setC;
import static logic.BCM.setCapacity;
import static logic.BCM.setD;
import static logic.BCM.setE;
import static logic.BCM.setF;
import static logic.BCM.setHybrydizationFactor;
import static logic.BCM.setIterations;
import static logic.BCM.setMutationFactor;
import static logic.BCM.setNumberOfIndividualsInIteration;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class EntireProgramTest {

    @Test
    public void finalPopulationTest() {
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

        setIterations(1000);
        setNumberOfIndividualsInIteration(100);

        bcm.generateProjects();

        int n = bcm.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().size();

        int f1 = bcm.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(0).getFitness();
        int f2 = bcm.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(n - 1).getFitness();

        assertTrue(f1 <= f2);
    }

    @Test
    public void rectangleCanteenTest() {
        BCM bcm = new BCM();

        setA(10);
        setB(10);
        setC(0);
        setD(0);
        setE(10);
        setF(10);

        setBudget(50000);
        setCapacity(20);

        setHybrydizationFactor(0.5);
        setMutationFactor(0.5);

        setIterations(1000);
        setNumberOfIndividualsInIteration(100);

        bcm.generateProjects();
    }

}
