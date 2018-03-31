package logic;

import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class BCM {

    private static double a;
    private static double b;
    private static double c;
    private static double d;
    private static double e;
    private static double f;

    private static double budget;//oczekiwany budżet stołówki
    private static int capacity;//oczekiwana liczba miejsc w stołówce
    private static int iterations;//liczba iteracji algorytmu genetycznego
    private static int numberOfIndividualsInIteration;//liczba osobników danej populacji
    private static double hybrydizationFactor;//współczynnik krzyżowania
    private static double mutationFactor;//współczynnik mutacji
    
    private boolean stopFlag;
    private Integer actualIteration;
    private Integer iterationsSpeed;

    private Population population;
    private Population bestIndividualInEachIterationPopulation;//populacja zawierająca osobniki z każdej iteracji o najwyższym współczynniku dostosowania
    private FitnessCounter fc;
    private GeneticAlgorithm ga;

    /**
     * Metoda ta generuje projekty stołówek zawierające współrzedne rozstawienia
     * poszczególnych obiektów w stołówce.
     */
    public void generateProjects(){
        population = new Population(numberOfIndividualsInIteration);
        bestIndividualInEachIterationPopulation = new Population(numberOfIndividualsInIteration);
        population.createPopulation();
        fc = new FitnessCounter(population);
        fc.calculateFitness();
        fc.writePopulationComfortFactors();
        ga = new GeneticAlgorithm(population, hybrydizationFactor, mutationFactor, iterations);

        for (int i = 0; i < iterations; i++) {
            population = ga.evolve(population);
            fc.setPopulation(population);
            fc.calculateFitness();

            bestIndividualInEachIterationPopulation.getIndividualsPopulation().add(fc.findBestIndividualInPopulation());
        }

        fc.setPopulation(bestIndividualInEachIterationPopulation);
        fc.writePopulationComfortFactors();
    }

    public Population getBestIndividualInEachIterationPopulation() {
        return bestIndividualInEachIterationPopulation;
    }

    public static double getA() {
        return a;
    }

    public static void setA(double a) {
        BCM.a = a;
    }

    public static double getB() {
        return b;
    }

    public static void setB(double b) {
        BCM.b = b;
    }

    public static double getC() {
        return c;
    }

    public static void setC(double c) {
        BCM.c = c;
    }

    public static double getD() {
        return d;
    }

    public static void setD(double d) {
        BCM.d = d;
    }

    public static double getE() {
        return e;
    }

    public static void setE(double e) {
        BCM.e = e;
    }

    public static double getF() {
        return f;
    }

    public static void setF(double f) {
        BCM.f = f;
    }

    public static double getBudget() {
        return budget;
    }

    public static void setBudget(double budget) {
        BCM.budget = budget;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        BCM.capacity = capacity;
    }

    public static int getIterations() {
        return iterations;
    }

    public static void setIterations(int iterations) {
        BCM.iterations = iterations;
    }

    public Integer getActualIteration() {
		return actualIteration;
	}

	public void setActualIteration(Integer actualIteration) {
		this.actualIteration = actualIteration;
	}

	public static int getNumberOfIndividualsInIteration() {
        return numberOfIndividualsInIteration;
    }

    public static void setNumberOfIndividualsInIteration(int numberOfIndividualsInIteration) {
        BCM.numberOfIndividualsInIteration = numberOfIndividualsInIteration;
    }

    public static double getHybrydizationFactor() {
        return hybrydizationFactor;
    }

    public static void setHybrydizationFactor(double hybrydizationFactor) {
        BCM.hybrydizationFactor = hybrydizationFactor;
    }

    public static double getMutationFactor() {
        return mutationFactor;
    }

    public static void setMutationFactor(double mutationFactor) {
        BCM.mutationFactor = mutationFactor;
    }


	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	public Integer getIterationsSpeed() {
		return iterationsSpeed;
	}

	public void setIterationsSpeed(Integer iterationsSpeed) {
		this.iterationsSpeed = iterationsSpeed;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}
	
    
    public BCM(){
    	a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;

        budget = 0;
        capacity = 0;
        iterations = 0;
        numberOfIndividualsInIteration = 0;
        hybrydizationFactor = 0;
        mutationFactor = 0;
        
        stopFlag = false;
        actualIteration = 0;
        iterationsSpeed = 0;
    }

}


