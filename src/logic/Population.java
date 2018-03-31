package logic;

import java.util.ArrayList;
import logic.Individual;

/**
 *
 * @author Kuba
 */
public class Population {

    private ArrayList<Individual> individualsPopulation;
    private IndividualCounter ic = new IndividualCounter();
    private int sizePopulation;

    public Population(int sizePopulation) {
        individualsPopulation = new ArrayList<Individual>();
        this.sizePopulation = sizePopulation;
        //createPopulation(sizePopulation);
    }

    public ArrayList<Individual> getIndividualsPopulation() {
        return individualsPopulation;
    }

    public int individualsPopulationSize() {
        return individualsPopulation.size();
    }

    /**
     * Metoda ta ma za zadanie utworzenie populacji liczacej „sizePopulation”
     * osobników.
     */
    public void createPopulation() {
        for (int i = 0; i < sizePopulation; i++) {
            individualsPopulation.add(new Individual());
        }
        for (int i = 0; i < sizePopulation; i++) {
            ic.generateIndividual(individualsPopulation.get(i));
        }
    }

   
}
