package logic;

import static logic.BCM.*;

/**
 *
 * @author Kuba
 */
public class FitnessCounter {

    private Population population;
    private double theLowestCost = Double.MAX_VALUE;
    private int maxNumberOfTables = 0;
    private int maxNumberOfSittingPlaces = 0;

    private int solution;

    private static final double sittingPlacesComfortWeight = 1;
    private static final double costComfortWeight = 1;
    private static final double tablesComfortWeight = 0.8;
    private static final double lightningComfortWeight = 0.6;
    private static final double windowsComfortWeight = 0.75;
    private static final double shopComfortWeight = 0.5;
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double budget;

    /**
     *
     * @param population populacja osobników dla której liczymy poziom
     * dopasowania
     */
    public FitnessCounter(Population population) {
        a = getA();
        b = getB();
        c = getC();
        d = getD();
        e = getE();
        f = getF();
        budget = getBudget();
        this.population = population;
        this.solution = (int) (100 * sittingPlacesComfortWeight + 100 * costComfortWeight + 100 * tablesComfortWeight + 100 * lightningComfortWeight + 100 * windowsComfortWeight + 100 * shopComfortWeight);
    }

    /**
     * Metoda ta zwraca wartosc współczynnika dostosowania
     *
     */
    public void calculateFitness() {
        Individual tmp;

        calculateComfort();

        for (int i = 0; i < population.getIndividualsPopulation().size(); i++) {
            tmp = population.getIndividualsPopulation().get(i);
            tmp.setFitness((int) (tmp.getComfortPoints() * 100 / solution));
        }
    }

    /**
     * Metoda zwracająca populację
     *
     * @return populacja
     */
    public Population getPopulation() {
        return population;
    }

    /**
     * Metoda ustalająca populację
     *
     * @param population populacja do ustawienia
     */
    public void setPopulation(Population population) {
        this.population = population;
    }

    /**
     * Metoda ta znajduje najlepszego osobnika w populacji.
     *
     * @return najlepszy osobnik w danej populacji
     */
    public Individual findBestIndividualInPopulation() {
        Individual bestIndividual = population.getIndividualsPopulation().get(0);
        for (int i = 1; i < population.getIndividualsPopulation().size(); i++) {
            if (population.getIndividualsPopulation().get(i).getComfortPoints() > bestIndividual.getComfortPoints()) {
                bestIndividual = population.getIndividualsPopulation().get(i);
            }
        }
        return bestIndividual;
    }

    /**
     * Metoda ta wypisuje wartości współczynników komfortu poszczególnych
     * osobników z danej populacji.
     */
    public void writePopulationComfortFactors() {
        Individual tmp;
        for (int i = 0; i < population.getIndividualsPopulation().size(); i++) {
            tmp = population.getIndividualsPopulation().get(i);
            System.out.println("Komfort mejsc siedzących" + "(max " + (100 * sittingPlacesComfortWeight) + " pkt): " + tmp.getSittingPlacesComfort() + " pkt");
            System.out.println("Komfort kosztów" + "(max[" + (100 * costComfortWeight) + " pkt]): " + tmp.getCostComfort() + " pkt");
            System.out.println("Komfort stołów" + "(max[" + (100 * tablesComfortWeight) + " pkt]): " + tmp.getTablesComfort() + " pkt");
            System.out.println("Komfort oświetlenia" + "(max[" + (100 * lightningComfortWeight) + " pkt]): " + tmp.getLightningComfort() + " pkt");
            System.out.println("Komfort okien" + "(max[" + (100 * windowsComfortWeight) + " pkt]): " + tmp.getWindowsComfort() + " pkt");
            System.out.println("Komfort sklepu" + "(max[" + (100 * shopComfortWeight) + " pkt]): " + tmp.getShopComfort() + " pkt");
            System.out.println("Suma punktów komfortu osobnika: " + tmp.getComfortPoints() + " pkt");
            System.out.println("Maksymalna możliwa suma punktów komfortu osobnika: " + solution + " pkt");
            System.out.println("Poziom dostosowania danego osobnika: " + tmp.getFitness() + " %");
            System.out.println("Suma kosztów projektu = " + tmp.getCostSum() + " PLN");
            System.out.println();
        }
    }

    /**
     * Metoda ta wylicza wartość współczynnika komfortu poszczególnych elementów
     * stołówki dla całej populacji, wykorzystując do tego pozostałe metody z
     * tej klasy.
     */
    private void calculateComfort() {
        Individual tmp;
        int c1, c2, c3, c4, c5, c6;
        for (int i = 0; i < population.getIndividualsPopulation().size(); i++) {
            tmp = population.getIndividualsPopulation().get(i);
            c1 = calculateSeatsComfort(tmp);
            tmp.setSittingPlacesComfort(c1);
            c2 = calculateCostComfort(tmp);
            tmp.setCostComfort(c2);
            c3 = calculateTablesComfort(tmp);
            tmp.setTablesComfort(c3);
            c4 = calculateLightningComfort(tmp);
            tmp.setLightningComfort(c4);
            c5 = calculateWindowsComfort(tmp);
            tmp.setWindowsComfort(c5);
            c6 = calculateShopComfort(tmp);
            tmp.setShopComfort(c6);
            tmp.setComfortPoints(c1 + c2 + c3 + c4 + c5 + c6);
        }
    }

    /**
     * Metoda ta liczy komfort miejsc siedzących wdanej stołówce.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*sittingPlacesComfortWeight)
     */
    private int calculateSeatsComfort(Individual individual) {
        int tablesNumber = individual.getTablesCoordinates().size();
        int a, b;
        a = 0;
        b = 0;
        int maxTable = 0;//maksymalna liczba osóba jakie mogą usiąść przy tym stole
        int maxNumberOfSeatingPlaces = 0;

        for (int i = 0; i < tablesNumber; i++) {
            a = individual.getTablesCoordinates().get(i).getLengthX();
            b = individual.getTablesCoordinates().get(i).getLengthY();
            maxTable = 2 * a + 2 * b;
            maxNumberOfSeatingPlaces += maxTable;
        }

        findMaxNumberOfSittingPlaces();

        int p1 = (int) (0.25 * ((maxNumberOfSeatingPlaces - individual.getSeatsCoordinates().size()) * 100 / maxNumberOfSeatingPlaces));
        int p2 = (int) (0.75 * (100 - (maxNumberOfSittingPlaces - individual.getNumberOfSittingPlaces()) * 100 / maxNumberOfSittingPlaces));

        return (int) (sittingPlacesComfortWeight * (p1 + p2));
    }

    /**
     * Metoda ta oblicza komfort wynikający z kosztu wykorzystanych w stołówce
     * obiektów. Punkty te obliczane są na zasadzie porównania ich kosztu z
     * kosztem najtańszego projektu stołówki.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*costComfortWeight)
     */
    private int calculateCostComfort(Individual individual) {
        if (individual.getCostSum() >= budget) {
            return 0;
        } else {
            findMinCostInPopulation();

            return (int) (costComfortWeight * (100 - (individual.getCostSum() - theLowestCost) * 100 / individual.getCostSum()));
        }
    }

    /**
     * Metoda ta oblicza komfort wynikający z wielkości wybranych stołów i ich
     * liczby.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*tablesComfortWeight)
     */
    private int calculateTablesComfort(Individual individual) {
        int tablesNumber = individual.getNumberOfTables();
        double restaurantSurfaceArea = b * c + e * f;
        int a, b, tablesSurfaceArea;
        int p2 = 0;

        a = 0;
        b = 0;
        tablesSurfaceArea = 0;
        findMaxTableNumberInPopulation();

        p2 = (int) (0.5 * (100 - ((maxNumberOfTables - individual.getNumberOfTables()) * 100 / maxNumberOfTables)));

        for (int i = 0; i < tablesNumber; i++) {
            a = individual.getTablesCoordinates().get(i).getLengthX();
            b = individual.getTablesCoordinates().get(i).getLengthY();
            tablesSurfaceArea += (a * b);
        }
        int p1 = (int) (0.5 * ((restaurantSurfaceArea - tablesSurfaceArea) * 100 / restaurantSurfaceArea));

        return (int) (tablesComfortWeight * (p1 + p2));
    }

    /**
     * Metoda ta oblicza komfort wynikający z oświetlenia stołówki.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*lightningComfortWeight)
     */
    private int calculateLightningComfort(Individual individual) {
        double surfaceArea = b * c + e * f;
        if (individual.getNumberOfLamps() * 3 >= surfaceArea) {
            return (int) (lightningComfortWeight * 100);
        } else {
            return (int) (lightningComfortWeight * ((individual.getNumberOfLamps() * 3 * 100) / surfaceArea));
        }

    }

    /**
     * Metoda ta oblicza komfort ustawienia w stołówce sklepiku. Komfort
     * sklepiku obliczany jest wyłącznie na podstawie jego odległości od drzwi
     * wyjściowych.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*shopComfortWeight)
     */
    private int calculateShopComfort(Individual individual) {
        double doorX = individual.getDoor().getX();
        double doorY = individual.getDoor().getY();
        double shoopMiddleX = individual.getShop().getX() + individual.getShop().getLengthX() / 2;
        double shoopMiddleY = individual.getShop().getY() + individual.getShop().getLengthY() / 2;

        return (int) (shopComfortWeight * (((Math.abs(doorX - shoopMiddleX) * 100 / f) + (Math.abs(doorY - shoopMiddleY) * 100 / a)) / 2));
    }

    /**
     * Metoda ta oblicza komfort ustawienia okien w stołówce. Komfort jest tym
     * większy, im większą powierzchnię pokrywają okna.
     *
     * @param individual osobnik w którym zapisać punkty komfortu
     * @return liczba punktów komfortu (max 100*windowsComfortWeight)
     */
    private int calculateWindowsComfort(Individual individual) {
        double maxWindowsSpace;
        double windowsLengthSum = 0;

        double ww = 0.75 + 0.8;
        int maxWindowNumber = (int) ((a - 1) / ww) + (int) ((b - 1) / ww) + (int) ((c - 1) / ww) + (int) ((d - 1) / ww) + (int) ((e - 1) / ww) + (int) ((f - 1) / ww);
        maxWindowsSpace = maxWindowNumber * 0.75;
        windowsLengthSum = individual.getNumberOfWindows() * 0.75;
        if (maxWindowsSpace < windowsLengthSum) {
            System.out.println(" " + individual.getNumberOfWindows() + " " + individual.getDistanceBetweenWindows() + " " + individual.getWindowsSize());
        }
        //System.out.println(individual.getNumberOfWindows());

        return (int) (windowsComfortWeight * ((windowsLengthSum * 100) / maxWindowsSpace));
    }

    /**
     * Metoda ta znajduje najniższy koszt stołówki spośród osobników danej
     * populacji.
     *
     * @return najniższy koszt skonstruowania stołówki w danej populacji
     */
    private double findMinCostInPopulation() {
        double minCost;
        for (int i = 0; i < population.individualsPopulationSize(); i++) {
            if (population.getIndividualsPopulation().get(i).getCostSum() < theLowestCost) {
                theLowestCost = population.getIndividualsPopulation().get(i).getCostSum();
            }
        }

        minCost = theLowestCost;

        return minCost;
    }

    /**
     * Metoda ta znajduje największą liczbę stołów spośród osobników danej
     * populacji.
     *
     * @return największa liczba stołów w danej populacji
     */
    private int findMaxTableNumberInPopulation() {
        int maxTableNumber = 0;
        for (int i = 0; i < population.individualsPopulationSize(); i++) {
            if (population.getIndividualsPopulation().get(i).getNumberOfTables() > maxNumberOfTables) {
                maxNumberOfTables = population.getIndividualsPopulation().get(i).getNumberOfTables();
            }
        }
        maxTableNumber = maxNumberOfTables;

        return maxTableNumber;
    }

    /**
     * Metoda ta znajduje największą liczbę miejsc siedzących spośród osobników
     * danej populacji.
     *
     * @return największa liczba miejsc siedzących w danej populacji
     */
    private int findMaxNumberOfSittingPlaces() {
        int maxTableNumber = 0;
        for (int i = 0; i < population.individualsPopulationSize(); i++) {
            if (population.getIndividualsPopulation().get(i).getNumberOfTables() > maxNumberOfSittingPlaces) {
                maxNumberOfSittingPlaces = population.getIndividualsPopulation().get(i).getNumberOfSittingPlaces();
            }
        }
        maxTableNumber = maxNumberOfSittingPlaces;

        return maxTableNumber;
    }
}
