package logic;

import dynamicstructures.Coordinates;
import canteencomponents.*;
import dynamicstructures.Matrix;
import java.util.Random;
import static logic.BCM.*;

/**
 *
 * @author Kuba
 */
public class IndividualCounter {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    private Table[] tables;
    private Seat[] seats;
    private Window[] windows;
    private Shop[] shops;
    private Lamp lamps;
    private Door doors;
    private int matrixRowNumber;
    private int matrixColumnNumber;
    private Matrix m;
    private Random r;

    public IndividualCounter() {
        initRestaurantComponents();
        a = getA();
        b = getB();
        c = getC();
        d = getD();
        e = getE();
        f = getF();
        matrixRowNumber = (int) c + (int) e;
        matrixColumnNumber = (int) b + (int) d;
        m = new Matrix(matrixRowNumber, matrixColumnNumber);
        r = new Random();
    }

    public void generateIndividual(Individual individual) {
        m.fillAllMatrix(1);

        for (int i = 0; i < (int) c; i++) {
            for (int j = (matrixColumnNumber - (int) d); j < matrixColumnNumber; j++) {
                if (m.get(i, j) == 1) {
                    m.put(0, i, j);
                }
            }
        }

        Coordinates doorCoordinates = null;
        Coordinates shopCoordinates = null;

        //System.out.println();
        //m.writeMatrix();
        if ((m.getRowNumber() >= 3 && (int) b >= 3) || (m.getRowNumber() >= 4 && (int) b >= 2) || (m.getRowNumber() >= 2 && (int) b >= 4) || ((int) e >= 4 && m.getColumnNumber() >= 2) || ((int) e >= 2 && m.getColumnNumber() >= 4) || ((int) e >= 3 && m.getColumnNumber() >= 3)) {
            while ((shopCoordinates = setShop(individual)) == null) {
                ;
            }
        }

        //System.out.println();
        //m.writeMatrix();
        while ((doorCoordinates = setDoor(individual)) == null) {
            ;
        }

        //System.out.println();
        //m.writeMatrix();
        if (shopCoordinates != null) {
            //System.out.println("shopCoordinates: x=" + individual.getShop().getX() + " y=" + individual.getShop().getY());
        }
        //System.out.println("doorCoordinates: x=" + doorCoordinates.getX() + " y=" + doorCoordinates.getY());

        setEscapeRoute(individual, doorCoordinates);

        //m.writeMatrix();
        //setSmallTables(individual);//////////////////
        int z1 = setRandomTablesAndSeats(individual);
        //System.out.println("Liczba miejsc to: " + z1);

        //System.out.println();
        //m.writeMatrix();
        double distanceBetweenLampsX = r.nextDouble() * 2 + 1;
        double distanceBetweenLampsY = r.nextDouble() * 2 + 1;
        int windowsType = r.nextInt(windows.length);
        double distanceBetweenWindows = r.nextDouble() + 1;

        int z2 = setLighting(individual, distanceBetweenLampsX, distanceBetweenLampsY);
        int z3 = setWindows(individual, distanceBetweenWindows, windows[windowsType]);

        individual.setDistanceBetweenLampsX(distanceBetweenLampsX);
        individual.setDistanceBetweenLampsY(distanceBetweenLampsY);
        individual.setWindowsSize(windows[windowsType].getLength());
        individual.setDistanceBetweenWindows(distanceBetweenWindows);

        //System.out.println("Liczba ustawionych w stołówce lamp to: " + z2);
        //System.out.println("Liczba ustawionych okien to: " + z3);
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Metoda ta tworzy poszczególne obiekty umieszczane na powierzchni
     * stołówki.
     */
    private void initRestaurantComponents() {
        tables = new Table[8];
        seats = new Seat[1];
        windows = new Window[3];
        shops = new Shop[3];

        doors = new Door(1, 1000, 1);
        lamps = new Lamp(150, 1);
        tables[0] = new Table(1, 1, 150, 1);
        tables[1] = new Table(2, 1, 200, 2);
        tables[2] = new Table(1, 2, 200, 3);
        tables[3] = new Table(3, 1, 250, 4);
        tables[4] = new Table(1, 3, 250, 5);
        tables[5] = new Table(2, 2, 300, 6);
        tables[6] = new Table(3, 2, 400, 7);
        tables[7] = new Table(2, 3, 400, 8);

        seats[0] = new Seat(75, 1);

        windows[0] = new Window(0.75, 500, 1);
        windows[1] = new Window(1, 700, 2);
        windows[2] = new Window(1.5, 1100, 3);

        shops[0] = new Shop(3, 3, 1000, 1);
        shops[1] = new Shop(2, 4, 800, 2);
        shops[2] = new Shop(4, 2, 800, 3);
    }

    /**
     * Metoda ta bada wielkość dostępnej przestrzeni do ustawienia stołu.
     */
    private Coordinates exploreSpace(Coordinates c) {

        int x = c.getX();
        int y = c.getY();
        int t1, t2;
        t1 = 0;//x
        t2 = 0;//y
        int xmax, ymax;
        boolean first = true;

        xmax = m.getColumnNumber();
        ymax = m.getRowNumber();

        while (m.get(y, x) != 0) {
            for (int i = x; i < m.getColumnNumber() && i <= xmax; i++) {
                if (m.get(y, i) == 0) {
                    break;
                }
                t1++;
            }

            for (int i = y; i < m.getRowNumber() && i <= ymax; i++) {
                if (m.get(i, x) == 0) {
                    break;
                }
                t2++;
            }

            if (first) {
                xmax = x + t1 - 1;
                ymax = y + t2 - 1;
                first = false;
            }
            if (x + t1 - 1 <= xmax) {
                xmax = x + t1 - 1;
            }
            if (y + t2 - 1 <= ymax) {
                ymax = y + t2 - 1;
            }

            if (t1 <= 1 && t2 <= 1) {
                break;
            }
            if (t1 > 1) {
                x++;
            }
            if (t2 > 1) {
                y++;
            }
            t1 = 0;
            t2 = 0;
        }

        return new Coordinates(xmax, ymax);
    }

    /**
     * Metoda ta ustawia na powierzchni stołówki sklepik.
     *
     * @param individual osobnik w którym zapisać współrzędne ustawionego
     * sklepiku
     * @return współrzędne ustawionego sklepiku
     */
    public Coordinates setShop(Individual individual) {
        int x = r.nextInt(5) + 1;
        int s = r.nextInt(3);
        int xl, yl;
        xl = shops[s].getLengthX();
        yl = shops[s].getLengthY();
        double costSum;

        switch (x) {
            case 1:
                if ((xl <= (int) b) && ((yl <= m.getRowNumber()))) {
                    m.fillAreaInMatrix(0, 0, yl, 0, xl);
                    individual.setShop(new Shop(0, 0, xl, yl, shops[s].getPrice(), shops[s].getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + shops[s].getPrice());
                    return new Coordinates(0, 0);
                } else {
                    return setShop(individual);
                }
            case 2:
                if ((xl <= (int) b) && ((yl <= (int) c))) {
                    m.fillAreaInMatrix(0, 0, yl, ((int) b) - xl, (int) b);
                    individual.setShop(new Shop(((int) b) - xl, 0, xl, yl, shops[s].getPrice(), shops[s].getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + shops[s].getPrice());
                    return new Coordinates(((int) b) - xl, 0);
                } else {
                    return setShop(individual);
                }
            case 3:
                if ((xl <= (int) d) && ((yl <= (int) e))) {
                    m.fillAreaInMatrix(0, (int) c, ((int) c) + yl, m.getColumnNumber() - xl, m.getColumnNumber());
                    individual.setShop(new Shop(m.getColumnNumber() - xl, (int) c, xl, yl, shops[s].getPrice(), shops[s].getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + shops[s].getPrice());
                    return new Coordinates(m.getColumnNumber() - xl, (int) c);
                } else {
                    return setShop(individual);
                }
            case 4:
                if ((xl <= m.getColumnNumber()) && ((yl <= (int) e))) {
                    m.fillAreaInMatrix(0, m.getRowNumber() - yl, m.getRowNumber(), m.getColumnNumber() - xl, m.getColumnNumber());
                    individual.setShop(new Shop(m.getColumnNumber() - xl, m.getRowNumber() - yl, xl, yl, shops[s].getPrice(), shops[s].getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + shops[s].getPrice());
                    return new Coordinates(m.getColumnNumber() - xl, m.getRowNumber() - yl);
                } else {
                    return setShop(individual);
                }
            case 5:
                if ((xl <= m.getColumnNumber()) && ((yl <= (int) e))) {
                    m.fillAreaInMatrix(0, m.getRowNumber() - yl, m.getRowNumber(), 0, xl);
                    individual.setShop(new Shop(0, m.getRowNumber() - yl, xl, yl, shops[s].getPrice(), shops[s].getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + shops[s].getPrice());
                    return new Coordinates(0, m.getRowNumber() - yl);
                } else {
                    return setShop(individual);
                }
        }
        return null;
    }

    /**
     * Metoda ta ustawia tylko stoły o wielkości 1x1 na powierzchyni stołóki,
     * tylko po to aby dobrać wszystkie parametry stołówki poza rodzajami stołów
     * - pierwsza część dopasowywania.
     */
    /*public int setSmallTables(Individual individual) {
        int smallTablesNumber = 0;
        int sittingPlaces = 0;
        int standingPlaces = 0;

        for (int i = 0; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if (m.get(i, j) != 0) {
                    if ((i + 1 < m.getRowNumber() && m.get(i + 1, j) != 0) || (j + 1 < m.getColumnNumber() && m.get(i, j + 1) != 0)) {
                        m.put(0, i, j);
                        sittingPlaces += setSeats(new Coordinates(j, i), tables[0]);
                    }
                }
            }
        }

        return sittingPlaces;
        //System.out.println("sittingPlaces=" + sittingPlaces);
    }*/
    /**
     * Metoda ta ustawia na powierzchni stołówki losowe rodzaje stołów, tak aby
     * algorytm genetyczny dobierał takie rodzaje stołów i ich ustawienie, aby
     * koszt projektu był jak najmniejszy, a liczba miejsc siedzących jak
     * największa - druga część dopasowywania.
     */
    public int setRandomTablesAndSeats(Individual individual) {
        int tablesNumber = 0;
        int sittingPlaces = 0;
        int tableMaxLengthX = 0;
        int tableMaxLengthY = 0;
        int tableNumber;
        int numberOfTables = 0;
        double costSum;

        for (int i = 0; i < m.getRowNumber(); i++) {
            for (int j = 0; j < m.getColumnNumber(); j++) {
                if (m.get(i, j) != 0) {
                    Coordinates c1 = new Coordinates(j, i);
                    Coordinates c2 = exploreSpace(c1);
                    if (!c2.equals(c1)) {
                        tableMaxLengthX = c2.getX() - c1.getX() + 1;
                        tableMaxLengthY = c2.getY() - c1.getY() + 1;

                        while (true) {
                            tableNumber = r.nextInt(tables.length);
                            if (((tables[tableNumber].getLengthX() < tableMaxLengthX) && (tables[tableNumber].getLengthY() <= tableMaxLengthY)) || ((tables[tableNumber].getLengthY() < tableMaxLengthY) && (tables[tableNumber].getLengthX() <= tableMaxLengthX))) {
                                individual.getTablesCoordinates().add(new Table(j, i, tables[tableNumber].getLengthX(), tables[tableNumber].getLengthY(), tables[tableNumber].getPrice(), tables[tableNumber].getImageID()));
                                m.fillAreaInMatrix(0, i, i + tables[tableNumber].getLengthY(), j, j + tables[tableNumber].getLengthX());
                                costSum = individual.getCostSum();
                                individual.setCostSum(costSum + tables[tableNumber].getPrice());

                                sittingPlaces += setSeats(new Coordinates(j, i), tables[tableNumber], individual);

                                numberOfTables++;
                                break;
                            }
                        }
                    }
                }
                individual.setNumberOfTables(numberOfTables);
                individual.setNumberOfSittingPlaces(sittingPlaces);
            }
        }
        //System.out.println(numberOfTables);

        return sittingPlaces;
    }

    /**
     * Metoda ta ustawia wokół danego stołu miejsca siedzące, zapamiętując
     * lokalizacje ustawionych miejsc - druga część dopasowania.
     *
     * @param c współrzędne ustawienia stołu
     * @param t typ ustawionego stołu
     * @param individual osobnik w którym zapisać współrzędne
     * @return liczba ustawionych miejsc wokół stołu
     */
    public int setSeats(Coordinates c, Table t, Individual individual) {
        int x = c.getX();
        int y = c.getY();
        int tableLengthX = t.getLengthX();
        int tableLengthY = t.getLengthY();
        int seatnumber = 0;
        double costSum;

        //top side of table
        if (x - 1 > 0 && y - 1 > 0) {
            m.put(0, y - 1, x - 1);
        }
        for (int i = x; i < x + tableLengthX; i++) {
            if (y - 1 >= 0 && m.get(y - 1, i) != 0) {
                individual.getSeatsCoordinates().add(new Seat(i, y - 1, 0, seats[0].getPrice(), seats[0].getImageID()));
                m.put(0, y - 1, i);
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + seats[0].getPrice());
                seatnumber++;
            }
        }
        //right side of table
        if (x + tableLengthX < m.getColumnNumber() && y - 1 > 0) {
            m.put(0, y - 1, x + tableLengthX);
        }
        for (int i = y; i < y + tableLengthY; i++) {
            if (x + tableLengthX < m.getColumnNumber() && m.get(i, x + tableLengthX) != 0) {
                individual.getSeatsCoordinates().add(new Seat(x + tableLengthX, i, 1, seats[0].getPrice(), seats[0].getImageID()));
                m.put(0, i, x + tableLengthX);
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + seats[0].getPrice());
                seatnumber++;
            }
        }
        //down side of table
        if (x + tableLengthX < m.getColumnNumber() && y + tableLengthY < m.getRowNumber()) {
            m.put(0, y + tableLengthY, x + tableLengthX);
        }
        for (int i = x; i < x + tableLengthX; i++) {
            if (y + tableLengthY < m.getRowNumber() && m.get(y + tableLengthY, i) != 0) {
                individual.getSeatsCoordinates().add(new Seat(i, y + tableLengthY, 2, seats[0].getPrice(), seats[0].getImageID()));
                m.put(0, y + tableLengthY, i);
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + seats[0].getPrice());
                seatnumber++;
            }
        }
        //left side of table
        if (x - 1 >= 0 && y + tableLengthY < m.getRowNumber()) {
            m.put(0, y + tableLengthY, x - 1);
        }
        for (int i = y; i < y + tableLengthY; i++) {
            if (x - 1 >= 0 && m.get(i, x - 1) != 0) {
                individual.getSeatsCoordinates().add(new Seat(x - 1, i, 3, seats[0].getPrice(), seats[0].getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + seats[0].getPrice());
                m.put(0, i, x - 1);
                seatnumber++;
            }
        }

        return seatnumber;
    }

    /**
     * Metoda ta ustawia na ścianie stołówki drzwi.
     *
     * @param individual osobnik w którym zapisać współrzędne
     * @return współrzędne ustawionych drzwi
     */
    public Coordinates setDoor(Individual individual) {
        int x = r.nextInt(6) + 1;
        int z;
        double costSum;
        switch (x) {
            case 1://ustawienie na ścianie "a"
                if ((int) m.getRowNumber() != 0) {
                    z = r.nextInt(m.getRowNumber());
                    if (m.get(z, 0) != 0) {
                        m.put(0, z, 0);
                        individual.setDoor(new Door(0, z, doors.getLength(), 1, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(0, z);
                    } else {
                        return setDoor(individual);
                    }
                }
            case 2://ustawienie na ścianie "b"
                if ((int) b != 0) {
                    z = r.nextInt((int) b);
                    if (((int) b > 0) && (m.get(0, z) != 0)) {
                        m.put(0, 0, z);
                        individual.setDoor(new Door(z, 0, doors.getLength(), 0, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(z, 0);
                    } else {
                        return setDoor(individual);
                    }
                }
            case 3://ustawienie na ścianie "c"
                if ((int) c != 0) {
                    z = r.nextInt((int) c);
                    if (b > 0 && (int) c > 0 && (m.get(z, ((int) b) - 1) != 0)) {
                        m.put(0, z, ((int) b) - 1);
                        individual.setDoor(new Door(b, z, doors.getLength(), 1, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(((int) b) - 1, z);
                    } else {
                        return setDoor(individual);
                    }
                }
            case 4://ustawienie na ścianie "d"
                if ((int) d != 0) {
                    z = r.nextInt((int) d);
                    if ((((int) b) + z) < (m.getColumnNumber()) && ((int) d > 0) && (int) c < m.getRowNumber() && (m.get((int) c, ((int) b) + z) != 0)) {
                        m.put(0, (int) c, ((int) b) + z);
                        individual.setDoor(new Door(b + z, (int) c, doors.getLength(), 0, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(((int) b) + z, (int) c);
                    } else {
                        return setDoor(individual);
                    }
                }
            case 5://ustawienie na ścianie "e"
                if ((int) e != 0) {
                    z = r.nextInt((int) e);
                    if ((int) e > 0 && (m.get((int) c + z, (m.getColumnNumber()) - 1) != 0)) {
                        m.put(0, (int) c + z, m.getColumnNumber() - 1);
                        individual.setDoor(new Door(f, c + z, doors.getLength(), 1, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(m.getColumnNumber() - 1, (int) c + z);
                    } else {
                        return setDoor(individual);
                    }
                }
            case 6://ustawienie na ścianie "f"
                if ((int) m.getColumnNumber() != 0) {
                    z = r.nextInt(m.getColumnNumber());
                    if (m.get((m.getRowNumber()) - 1, z) != 0) {
                        m.put(0, (m.getRowNumber()) - 1, z);
                        individual.setDoor(new Door(z, a, doors.getLength(), 0, doors.getPrice(), doors.getImageID()));
                        costSum = individual.getCostSum();
                        individual.setCostSum(costSum + doors.getPrice());
                        return new Coordinates(z, (m.getRowNumber()) - 1);
                    } else {
                        return setDoor(individual);
                    }
                }
        }
        return null;
    }

    /**
     * Metoda ta ustawia na powierzchni stołówki drogę ewakuacyjną.
     */
    public void setEscapeRoute(Individual individual, Coordinates doorCoordination) {
        int middle, xyc;
        int doorCoordinateX = doorCoordination.getX();
        int doorCoordinateY = doorCoordination.getY();
        int shopCoordinateX = (int) individual.getShop().getX();
        int shopCoordinateY = (int) individual.getShop().getY();

        if (m.getColumnNumber() >= m.getRowNumber()) {
            middle = (int) (((int) e) / 2);
            for (int i = 0; i < m.getColumnNumber(); i++) {
                m.put(0, ((int) c) + middle, i);
            }
            //ustawienie sciezki do drzwi
            if (doorCoordinateY < ((int) c) + middle) {
                xyc = doorCoordinateX;
                for (int i = doorCoordinateY; i < ((int) c) + middle; i++) {
                    m.put(0, i, xyc);
                }
            } else {
                xyc = doorCoordinateX;
                for (int i = ((int) c) + middle; i < doorCoordinateY; i++) {
                    m.put(0, i, xyc);
                }
            }
            //ustawienie sciezki do sklepiku
            if (shopCoordinateY < ((int) c) + middle) {
                xyc = shopCoordinateX + (int) (individual.getShop().getLengthX() / 2);
                for (int i = shopCoordinateY + individual.getShop().getLengthY(); i < ((int) c) + middle; i++) {
                    m.put(0, i, xyc);
                }
            } else {
                xyc = shopCoordinateX + (int) (individual.getShop().getLengthX() / 2);
                for (int i = ((int) c) + middle; i < doorCoordinateY; i++) {
                    m.put(0, i, xyc);
                }
            }
        } else {
            middle = (int) (((int) b) / 2);
            for (int i = 0; i < m.getRowNumber(); i++) {
                m.put(0, i, middle);
            }
            //ustawienie sciezki do drzwi
            if (doorCoordinateX < middle) {
                xyc = doorCoordinateY;
                for (int i = doorCoordinateX; i < middle; i++) {
                    m.put(0, xyc, i);
                }
            } else {
                xyc = doorCoordinateY;
                for (int i = middle; i < doorCoordinateX; i++) {
                    m.put(0, xyc, i);
                }
            }
            //ustawienie sciezki do sklepiku
            if (shopCoordinateY < middle) {
                xyc = shopCoordinateY + (int) (individual.getShop().getLengthY() / 2);
                for (int i = shopCoordinateX + individual.getShop().getLengthX(); i < middle; i++) {
                    m.put(0, xyc, i);
                }
            } else {
                xyc = shopCoordinateY + (int) (individual.getShop().getLengthY() / 2);
                for (int i = middle; i < individual.getShop().getX(); i++) {
                    m.put(0, xyc, i);
                }
            }
        }
    }

    /**
     * Metoda ta ustawia na powierzchni stołówki oświetlenie w ustalonych od
     * siebie odstępach i zapisuje wyliczone współrzędne w danym osobniku -
     * projekcie stołówki.
     *
     * @param individual osobnik w którym zapisać współrzędne lamp
     * @param x odstęp od siebie lamp rozpatrując odległość na osi "x"
     * @param y odstęp od siebie lamp rozpatrując odległość na osi "y"
     * @return liczba ustawionych lamp
     */
    public int setLighting(Individual individual, double x, double y) {
        int lampNumber = 0;

        double canteenLengthX = f;
        double canteenLengthY = a;

        int maxLampX = (int) f - 1;
        int maxLampY = (int) a - 1;

        int lampNumberX = (int) (maxLampX / x);
        int lampNumberY = (int) (maxLampY / y);

        double x2 = canteenLengthX / lampNumberX;
        double y2 = canteenLengthY / lampNumberY;

        double lampX;
        double lampY;

        for (lampY = y2; lampY < a; lampY += y2) {
            for (lampX = x2; lampX < f; lampX += x2) {
                if (((lampY <= c) && (lampX >= b) && (lampX < f)) || (lampX == c) || (lampY == d)) {
                } else {
                    individual.getLampsCoordinates().add(new Lamp(lampX, lampY, lamps.getPrice(), lamps.getImageID()));
                    lampNumber++;
                }
            }
        }
        double costSum = individual.getCostSum();
        individual.setCostSum(costSum + (lampNumber * lamps.getPrice()));
        individual.setDistanceBetweenLampsX(x);
        individual.setDistanceBetweenLampsY(y);
        individual.setNumberOfLamps(lampNumber);

        return lampNumber;
    }

    /**
     * Metoda ta ustawia na ścianach stołówki okna.
     *
     * @param l odstęp od siebie rozmieszczanych okien
     */
    public int setWindows(Individual individual, double l, Window window) {
        int windowsNumber = 0;
        int doorX = (int) individual.getDoor().getX();
        int doorY = (int) individual.getDoor().getX();
        int doorLength = (int) individual.getDoor().getLength();
        double costSum = 0;

        double it = 0;

        double ww = window.getLength() + l;
        int maxWindowNumber = 0;
        double windowsDistance = 0;

        //ustawienie okien na ścianie "a"
        maxWindowNumber = (int) ((a - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (a - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (a - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(0, it, window.getLength(), 1, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (a - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(0, it, window.getLength(), 1, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        //ustawienie okien na ścianie "c"
        maxWindowNumber = (int) ((c - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (c - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (c - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(b, it, window.getLength(), 1, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (c - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(b, it, window.getLength(), 1, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        //ustawienie okien na ścianie "e"
        maxWindowNumber = (int) ((e - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (e - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (e - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(f, it + c, window.getLength(), 1, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (e - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(f, it + c, window.getLength(), 1, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        //ustawienie okien na ścianie "b"
        maxWindowNumber = (int) ((b - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (b - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (b - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(it, 0, window.getLength(), 0, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (b - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(it, 0, window.getLength(), 0, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        //ustawienie okien na ścianie "d"
        maxWindowNumber = (int) ((d - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (d - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (d - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(it + b, c, window.getLength(), 0, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (d - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(it + b, c, window.getLength(), 0, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        //ustawienie okien na ścianie "f"
        maxWindowNumber = (int) ((f - 1) / ww);
        if (maxWindowNumber > 1) {
            windowsDistance = (f - 1 - (window.getLength() * maxWindowNumber)) / (maxWindowNumber - 1);
            for (it = 0.5; it <= (f - 0.5 - window.getLength()); it += windowsDistance) {
                if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                    individual.getWindowsCoordinates().add(new Window(it, a, window.getLength(), 0, window.getPrice(), window.getImageID()));
                    costSum = individual.getCostSum();
                    individual.setCostSum(costSum + window.getPrice());
                    windowsNumber++;
                    it += window.getLength();
                }
            }
        } else if (maxWindowNumber == 1) {
            it = (f - window.getLength()) / 2;
            if (((it < doorY) && (it + window.getLength() < doorY)) || ((it > doorY) && (it + window.getLength() > doorY))) {
                individual.getWindowsCoordinates().add(new Window(it, a, window.getLength(), 0, window.getPrice(), window.getImageID()));
                costSum = individual.getCostSum();
                individual.setCostSum(costSum + window.getPrice());
                windowsNumber++;
            }
        }

        individual.setDistanceBetweenWindows(l);
        individual.setWindowsSize(window.getLength());
        individual.setNumberOfWindows(windowsNumber);

        return windowsNumber;
    }

    public double calculateSumOfCost(Individual individual) {
        double sumOfCost = 0;

        for (int i = 0; i < individual.getTablesCoordinates().size(); i++) {
            sumOfCost += individual.getTablesCoordinates().get(i).getPrice();
        }

        for (int i = 0; i < individual.getSeatsCoordinates().size(); i++) {
            sumOfCost += individual.getSeatsCoordinates().get(i).getPrice();
        }

        for (int i = 0; i < individual.getWindowsCoordinates().size(); i++) {
            sumOfCost += individual.getWindowsCoordinates().get(i).getPrice();
        }

        for (int i = 0; i < individual.getLampsCoordinates().size(); i++) {
            sumOfCost += individual.getLampsCoordinates().get(i).getPrice();
        }

        sumOfCost += individual.getDoor().getPrice();

        sumOfCost += individual.getShop().getPrice();

        return sumOfCost;
    }

    public Window[] getWindows() {
        return windows;
    }

    public Table[] getTables() {
        return tables;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public Shop[] getShops() {
        return shops;
    }

    public Lamp getLamps() {
        return lamps;
    }

    public Door getDoors() {
        return doors;
    }

}
