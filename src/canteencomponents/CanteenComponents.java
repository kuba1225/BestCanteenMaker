package canteencomponents;

/**
 *
 * @author Kuba
 */
public class CanteenComponents {

    private double x = 0;
    private double y = 0;
    private double price;
    private int imageID;

    public CanteenComponents(double x, double y, double price, int imageID) {
        this.x = x;
        this.y = y;
        this.price = price;
        this.imageID = imageID;
    }

    public CanteenComponents(double price, int imageID) {
        this.price = price;
        this.imageID = imageID;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", price=" + price + ", imageID=" + imageID;
    }

}
