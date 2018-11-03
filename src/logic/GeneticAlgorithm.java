package logic;

import java.util.Collections;
import java.util.Random;
import canteencomponents.*;
import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class GeneticAlgorithm {

	private double hybrydizationFactor = 0.5;// wspó³czynnik krzy¿owania
	private double mutationFactor = 0.05;// wspó³czynnik mutacji
	private int iterationNumber;
	private int[] parentPopulationIndividualsNumber;// numery osobników populacji rodzicielskiej
	private Population population;
	private IndividualCounter ic;
	private Random r;
	private DataHolder dataHolder;

	public GeneticAlgorithm(Population population, DataHolder dataHolder) {
		this.hybrydizationFactor = dataHolder.getHybrydizationFactor();
		this.mutationFactor = dataHolder.getMutationFactor();
		this.iterationNumber = dataHolder.getIterations();
		this.r = new Random();
		this.parentPopulationIndividualsNumber = new int[population.getIndividualsPopulation().size()];
		this.population = population;
		this.ic = new IndividualCounter(dataHolder);
		this.dataHolder = dataHolder;
	}

	/**
	 * Metoda ta realizuje operacjê ewolucji na podanej populacji z wykorzystaniem
	 * pozosta³ych metod zawartych w tej klasie.
	 *
	 * @param population
	 *            populacja na której przeprowadziæ operacjê ewolucji
	 */
	public Population evolve(Population populationToEvolve) {
		// tournamentSelection(population);
		// mutate(population.getIndividualsPopulation().get(0));
		// crossover(population.getIndividualsPopulation().get(0),
		// population.getIndividualsPopulation().get(1));

		Population newPopulation = new Population(populationToEvolve.individualsPopulationSize(), dataHolder);

		tournamentSelection(populationToEvolve);
		// newPopulation.getIndividualsPopulation().clear();

		for (int i = 0; i < populationToEvolve.individualsPopulationSize(); i++) {
			Individual individual1 = populationToEvolve.getIndividualsPopulation()
					.get(parentPopulationIndividualsNumber[r.nextInt(parentPopulationIndividualsNumber.length)]);
			Individual individual2 = populationToEvolve.getIndividualsPopulation()
					.get(parentPopulationIndividualsNumber[r.nextInt(parentPopulationIndividualsNumber.length)]);
			Individual newIndividual = crossover(individual1, individual2);
			newPopulation.getIndividualsPopulation().add(newIndividual);
		}

		for (int i = 0; i < populationToEvolve.individualsPopulationSize(); i++) {
			mutate(populationToEvolve.getIndividualsPopulation().get(i));
		}

		return newPopulation;
	}

	/**
	 * Metoda ta implementuje krzyzowanie dwóch wybranych osobników danej populacji.
	 *
	 * @param i1
	 *            osobnik od którego pobraæ czêœæ genów do krzy¿owania
	 * @param i2
	 *            osobnik od którego pobraæ czêœæ genów do krzy¿owania
	 * @return nowy osobnik powsta³y po skrzy¿owaniu dwóch podanych osobników
	 */
	private Individual crossover(Individual individual1, Individual individual2) {
		Individual solutionIndividual = new Individual();

		double costSum;

		for (int i = 0; i < 3; i++) {
			// Crossover
			if (r.nextDouble() <= hybrydizationFactor) {
				switch (i) {
				case 0:// sklep, drzwi, sto³y, krzes³a
					copyArray(solutionIndividual.getSeatsCoordinates(), individual1.getSeatsCoordinates());

					copyArray(solutionIndividual.getTablesCoordinates(), individual1.getTablesCoordinates());

					Shop s = new Shop(individual1.getShop().getX(), individual1.getShop().getY(),
							individual1.getShop().getLengthX(), individual1.getShop().getLengthY(),
							individual1.getShop().getPrice(), individual1.getShop().getImageID());

					solutionIndividual.setShop(s);

					Door d = new Door(individual1.getDoor().getX(), individual1.getDoor().getY(),
							individual1.getDoor().getLength(), individual1.getDoor().getPosition(),
							individual1.getDoor().getPrice(), individual1.getDoor().getImageID());

					solutionIndividual.setDoor(d);

					solutionIndividual.setNumberOfSittingPlaces(individual1.getNumberOfSittingPlaces());
					solutionIndividual.setNumberOfTables(individual1.getNumberOfTables());

					break;
				case 1:// okna - wielkoœæ okna

					switch (r.nextInt(2)) {
					case 0:// wielkoœæ okna
						Window w = null;

						for (int ii = 0; ii < ic.getWindows().length; ii++) {
							if (ic.getWindows()[ii].getLength() == individual1.getWindowsSize()) {
								w = ic.getWindows()[ii];
							}
						}
						double distanceBetweenWindows = r.nextDouble() + 1;

						ic.setWindows(solutionIndividual, distanceBetweenWindows, w);
						break;
					case 1:// odleg³oœæ miêdzy oknami

						int windowsType = r.nextInt(ic.getWindows().length);

						ic.setWindows(solutionIndividual, individual1.getDistanceBetweenWindows(),
								ic.getWindows()[windowsType]);

						break;
					}

					break;
				case 2:// oswietlenie

					switch (r.nextInt(2)) {
					case 0:// odleg³osc X
						double distanceBetweenLampsY = r.nextDouble() * 2 + 1;
						ic.setLighting(solutionIndividual, individual1.getDistanceBetweenLampsX(),
								distanceBetweenLampsY);
						break;
					case 1:// odleg³osc Y
						double distanceBetweenLampsX = r.nextDouble() * 2 + 1;
						ic.setLighting(solutionIndividual, distanceBetweenLampsX,
								individual1.getDistanceBetweenLampsY());
						break;
					}
					break;
				}
			} else {
				switch (i) {
				case 0:// sklep, drzwi, sto³y, krzes³a
						// System.out.println(r.nextDouble());
					copyArray(solutionIndividual.getSeatsCoordinates(), individual2.getSeatsCoordinates());

					copyArray(solutionIndividual.getTablesCoordinates(), individual2.getTablesCoordinates());

					Shop s = new Shop(individual2.getShop().getX(), individual2.getShop().getY(),
							individual2.getShop().getLengthX(), individual2.getShop().getLengthY(),
							individual2.getShop().getPrice(), individual2.getShop().getImageID());

					solutionIndividual.setShop(s);

					Door d = new Door(individual2.getDoor().getX(), individual2.getDoor().getY(),
							individual2.getDoor().getLength(), individual2.getDoor().getPosition(),
							individual2.getDoor().getPrice(), individual2.getDoor().getImageID());

					solutionIndividual.setDoor(d);

					solutionIndividual.setNumberOfSittingPlaces(individual2.getNumberOfSittingPlaces());
					solutionIndividual.setNumberOfTables(individual2.getNumberOfTables());
					break;
				case 1:// okna - wielkoœæ okna

					switch (r.nextInt(2)) {
					case 0:// wielkoœæ okna
						Window w = null;

						for (int ii = 0; ii < ic.getWindows().length; ii++) {
							if (ic.getWindows()[ii].getLength() == individual2.getWindowsSize()) {
								w = ic.getWindows()[ii];
							}
						}
						double distanceBetweenWindows = r.nextDouble() + 1;

						ic.setWindows(solutionIndividual, distanceBetweenWindows, w);
						break;
					case 1:// odleg³oœæ miêdzy oknami

						int windowsType = r.nextInt(ic.getWindows().length);

						ic.setWindows(solutionIndividual, individual2.getDistanceBetweenWindows(),
								ic.getWindows()[windowsType]);

						break;
					}

					break;

				case 2:// oswietlenie

					switch (r.nextInt(2)) {
					case 0:// odleg³osc X
						double distanceBetweenLampsY = r.nextDouble() * 2 + 1;
						ic.setLighting(solutionIndividual, individual2.getDistanceBetweenLampsX(),
								distanceBetweenLampsY);
						break;
					case 1:// odleg³osc Y
						double distanceBetweenLampsX = r.nextDouble() * 2 + 1;
						ic.setLighting(solutionIndividual, distanceBetweenLampsX,
								individual2.getDistanceBetweenLampsY());
						break;
					}

					break;
				}
			}

			solutionIndividual.setCostSum(ic.calculateSumOfCost(solutionIndividual));
		}
		return solutionIndividual;
	}

	/**
	 * Metoda ta realizuje operacje mutacji losowo wybranego genu danej populacji.
	 *
	 * @param i
	 *            osobnik na którym przeprowadziæ mutacjê
	 */
	private void mutate(Individual individual) {
		int populationSize = population.getIndividualsPopulation().size();
		int randomGene = r.nextInt(3);
		int randomIndividual = r.nextInt(populationSize);
		Individual tmpIndividual = population.getIndividualsPopulation().get(randomIndividual);

		if (r.nextDouble() <= mutationFactor) {
			switch (randomGene) {
			case 0:// sklep, drzwi, sto³y, krzes³a
				individual.getSeatsCoordinates().clear();
				copyArray(individual.getSeatsCoordinates(), tmpIndividual.getSeatsCoordinates());

				individual.getTablesCoordinates().clear();
				copyArray(individual.getTablesCoordinates(), tmpIndividual.getTablesCoordinates());

				individual.getShop().setImageID(tmpIndividual.getShop().getImageID());
				individual.getShop().setLengthX(tmpIndividual.getShop().getLengthX());
				individual.getShop().setLengthY(tmpIndividual.getShop().getLengthY());
				individual.getShop().setPrice(tmpIndividual.getShop().getPrice());
				individual.getShop().setX(tmpIndividual.getShop().getX());
				individual.getShop().setY(tmpIndividual.getShop().getY());

				individual.getDoor().setImageID(tmpIndividual.getDoor().getImageID());
				individual.getDoor().setLength(tmpIndividual.getDoor().getLength());
				individual.getDoor().setPrice(tmpIndividual.getDoor().getPrice());
				individual.getDoor().setPosition(tmpIndividual.getDoor().getPosition());
				individual.getDoor().setX(tmpIndividual.getDoor().getX());
				individual.getDoor().setY(tmpIndividual.getDoor().getY());

				individual.setNumberOfSittingPlaces(tmpIndividual.getNumberOfSittingPlaces());
				individual.setNumberOfTables(tmpIndividual.getNumberOfTables());
				break;
			case 1:// okna
				switch (r.nextInt(2)) {
				case 0:// wielkoœæ okna
					individual.getWindowsCoordinates().clear();

					Window w = null;

					for (int i = 0; i < ic.getWindows().length; i++) {
						if (ic.getWindows()[i].getLength() == tmpIndividual.getWindowsSize()) {
							w = ic.getWindows()[i];
						}
					}
					double distanceBetweenWindows = r.nextDouble() + 1;

					ic.setWindows(individual, distanceBetweenWindows, w);
					break;
				case 1:// odleg³oœæ miêdzy oknami
					individual.getWindowsCoordinates().clear();

					int windowsType = r.nextInt(ic.getWindows().length);

					ic.setWindows(individual, tmpIndividual.getDistanceBetweenWindows(), ic.getWindows()[windowsType]);

					break;
				}

			case 2:// oswietlenie
				individual.getLampsCoordinates().clear();
				switch (r.nextInt(2)) {
				case 0:// odleg³osc X
					double distanceBetweenLampsY = r.nextDouble() * 2 + 1;
					ic.setLighting(individual, individual.getDistanceBetweenLampsX(), distanceBetweenLampsY);
					break;
				case 1:// odleg³osc Y
					double distanceBetweenLampsX = r.nextDouble() * 2 + 1;
					ic.setLighting(individual, distanceBetweenLampsX, individual.getDistanceBetweenLampsY());
					break;
				}

				break;
			}

		}

		individual.setCostSum(ic.calculateSumOfCost(individual));
	}

	/**
	 * Metoda ta realizuje selekcje populacji rodzicielskiej metoda ruletkowa.
	 *
	 */
	private void rouletteSelection(Population population) {
		double[] rankingTab = new double[population.getIndividualsPopulation().size()];
		int randomNumber, numberIndividual = 0;
		int comfortPointsSumOfPopulation = 0;
		int populationSize = population.getIndividualsPopulation().size();

		for (int i = 0; i < population.getIndividualsPopulation().size(); i++) {
			comfortPointsSumOfPopulation += population.getIndividualsPopulation().get(i).getComfortPoints();
		}

		for (int i = 0; i < population.getIndividualsPopulation().size(); i++) {
			rankingTab[i] = population.getIndividualsPopulation().get(i).getComfortPoints() * 100
					/ comfortPointsSumOfPopulation;
		}

		for (int i = 1; i < rankingTab.length - 1; i++) {
			rankingTab[i] += rankingTab[i - 1];
		}

		if (rankingTab.length - 1 > 0) {
			rankingTab[rankingTab.length - 1] = 100;
		}

		for (int j = 0; j < populationSize; j++) {
			randomNumber = r.nextInt(100);
			for (int i = 0; i < rankingTab.length; i++) {
				if (randomNumber <= rankingTab[i]) {
					numberIndividual = i;
					break;
				}
			}
			parentPopulationIndividualsNumber[j] = numberIndividual;
		}
	}

	/**
	 * Metoda ta realizuje selekcje populacji rodzicielskiej metoda turniejowa.
	 *
	 */
	private void tournamentSelection(Population population) {
		int populationSize = population.getIndividualsPopulation().size();
		int randomNumber1, randomNumber2, numberIndividual = 0;

		for (int j = 0; j < populationSize; j++) {
			randomNumber1 = r.nextInt(populationSize);
			randomNumber2 = r.nextInt(populationSize);
			if (randomNumber1 == randomNumber2) {
				while (randomNumber1 == randomNumber2) {
					randomNumber2 = r.nextInt(populationSize);
				}
			}

			Individual i1 = population.getIndividualsPopulation().get(randomNumber1);
			Individual i2 = population.getIndividualsPopulation().get(randomNumber2);

			if (i1.getComfortPoints() > i2.getComfortPoints()) {
				numberIndividual = randomNumber1;
			} else {
				numberIndividual = randomNumber2;
			}

			parentPopulationIndividualsNumber[j] = numberIndividual;
		}
	}

	private void copyArray(ArrayList dest, ArrayList src) {
		dest.clear();
		for (int i = 0; i < src.size(); i++) {
			dest.add(src.get(i));
		}
	}
}
