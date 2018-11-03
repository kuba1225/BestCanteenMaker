package logic;

import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class BCM {

	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;

	private double budget;// oczekiwany bud¿et sto³ówki
	private int capacity;// oczekiwana liczba miejsc w sto³ówce
	private int iterations;// liczba iteracji algorytmu genetycznego
	private int numberOfIndividualsInGeneration;// liczba osobników danej populacji
	private double hybrydizationFactor;// wspó³czynnik krzy¿owania
	private double mutationFactor;// wspó³czynnik mutacji

	private Integer iterationsSpeed;

	private Population population;
	private Population bestIndividualInEachIterationPopulation;// populacja zawieraj¹ca osobniki z ka¿dej iteracji o
																// najwy¿szym wspó³czynniku dostosowania
	private FitnessCounter fc;
	private GeneticAlgorithm ga;

	private DataHolder dataHolder;

	public BCM(DataHolder dataHolder) {
		this.a = dataHolder.getWallA();
		this.b = dataHolder.getWallB();
		this.c = dataHolder.getWallC();
		this.d = dataHolder.getWallD();
		this.e = dataHolder.getWallE();
		this.f = dataHolder.getWallF();

		this.budget = dataHolder.getBudget();
		this.capacity = dataHolder.getCapacity();
		this.iterations = dataHolder.getIterations();
		this.numberOfIndividualsInGeneration = dataHolder.getNumberOfIndividualsInGeneration();
		this.hybrydizationFactor = dataHolder.getHybrydizationFactor();
		this.mutationFactor = dataHolder.getMutationFactor();
		this.iterationsSpeed = dataHolder.getIterationsSpeed();

		this.dataHolder = dataHolder;
	}

	/**
	 * Metoda ta generuje projekty sto³ówek zawieraj¹ce wspó³rzedne rozstawienia
	 * poszczególnych obiektów w sto³ówce.
	 */
	public void generateProjects() {
		population = new Population(numberOfIndividualsInGeneration, dataHolder);
		bestIndividualInEachIterationPopulation = new Population(numberOfIndividualsInGeneration, dataHolder);
		population.createPopulation();
		fc = new FitnessCounter(dataHolder, population);
		fc.calculateFitness();
		fc.writePopulationComfortFactors();
		ga = new GeneticAlgorithm(population, dataHolder);

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

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public int getNumberOfIndividualsInGeneration() {
		return numberOfIndividualsInGeneration;
	}

	public void setNumberOfIndividualsInGeneration(int numberOfIndividualsInIteration) {
		this.numberOfIndividualsInGeneration = numberOfIndividualsInIteration;
	}

	public double getHybrydizationFactor() {
		return hybrydizationFactor;
	}

	public void setHybrydizationFactor(double hybrydizationFactor) {
		this.hybrydizationFactor = hybrydizationFactor;
	}

	public double getMutationFactor() {
		return mutationFactor;
	}

	public void setMutationFactor(double mutationFactor) {
		this.mutationFactor = mutationFactor;
	}

	public FitnessCounter getFc() {
		return fc;
	}

	public void setFc(FitnessCounter fc) {
		this.fc = fc;
	}

	public GeneticAlgorithm getGa() {
		return ga;
	}

	public void setGa(GeneticAlgorithm ga) {
		this.ga = ga;
	}

	public void setBestIndividualInEachIterationPopulation(Population bestIndividualInEachIterationPopulation) {
		this.bestIndividualInEachIterationPopulation = bestIndividualInEachIterationPopulation;
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

	@Override
	public String toString() {
		return "BCM [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + ", budget=" + budget
				+ ", capacity=" + capacity + ", iterations=" + iterations + ", numberOfIndividualsInGeneration="
				+ numberOfIndividualsInGeneration + ", hybrydizationFactor=" + hybrydizationFactor + ", mutationFactor="
				+ mutationFactor + ", iterationsSpeed=" + iterationsSpeed + ", population=" + population
				+ ", bestIndividualInEachIterationPopulation=" + bestIndividualInEachIterationPopulation + ", fc=" + fc
				+ ", ga=" + ga + "]";
	}

}
