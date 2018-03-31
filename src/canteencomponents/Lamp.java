package canteencomponents;

/**
 *
 * @author Kuba
 */
public class Lamp extends CanteenComponents {

    public Lamp(double x, double y, double price, int imageID) {
        super(x, y, price, imageID);
    }

    public Lamp(double price, int imageID) {
        super(price, imageID);
    }

    @Override
    public String toString() {
        return "Lamp{" + super.toString() + '}';
    }

}
