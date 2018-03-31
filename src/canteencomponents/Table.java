package canteencomponents;

/**
 *
 * @author Kuba
 */
public class Table extends CanteenComponents {

    private int lengthX;
    private int lengthY;

    public Table(double x, double y, int lengthX, int lengthY, double price, int imageID) {
        super(x, y, price, imageID);
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    public Table(int lengthX, int lengthY, double price, int imageID) {
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
        return "Table{" + super.toString() + ", lengthX=" + lengthX + ", lengthY=" + lengthY + '}';
    }

}
