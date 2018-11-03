package canteencomponents;

/**
 *
 * @author Kuba
 */
public class Seat extends CanteenComponents {

    /**
     * Z której strony sto³u ma zostaæ ustawione krzes³o: 0 - od góry, 1 - po
     * prawej, 2 - od do³u, 3 - po lewej
     */
    int sideOfTable;

    public Seat(double x, double y, int sideOfTable, double price, int imageID) {
        super(x, y, price, imageID);
        this.sideOfTable = sideOfTable;
    }

    public Seat(double price, int imageID) {
        super(price, imageID);
    }

    @Override
    public String toString() {
        if (sideOfTable == 0) {
            return "Seat{" + super.toString() + ",sideOfTable= " + " top " + '}';
        } else if (sideOfTable == 1) {
            return "Seat{" + super.toString() + ",sideOfTable= " + " right " + '}';
        } else if (sideOfTable == 2) {
            return "Seat{" + super.toString() + ",sideOfTable= " + " down " + '}';
        } else {
            return "Seat{" + super.toString() + ",sideOfTable= " + " left " + '}';
        }
    }

}
