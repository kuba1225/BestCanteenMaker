package canteencomponents;

/**
 *
 * @author Kuba
 */
public class Shop extends CanteenComponents {

    private int lengthX;
    private int lengthY;

    public Shop(double x, double y, int lengthX, int lengthY, double price, int imageID) {
        super(x, y, price, imageID);
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    public Shop(int lengthX, int lengthY, double price, int imageID) {
        super(price, imageID);
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    public int getLengthX() {
        return lengthX;
    }

    public void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    @Override
    public String toString() {
        return "Shop{" + super.toString() + ", lengthX=" + lengthX + ", lengthY=" + lengthY + '}';
    }

}
