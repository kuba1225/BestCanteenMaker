package canteencomponents;

/**
 *
 * @author Kuba
 */
public class Window extends CanteenComponents {

    private double length;
    private int position;//polozenie okna 1 - pionowe, 0 - poziome

    public Window(double x, double y, double length, int position, double price, int imageID) {
        super(x, y, price, imageID);
        this.length = length;
        this.position = position;
    }

    public Window(double length, double price, int imageID) {
        super(price, imageID);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        if (position == 0) {
            return "Window{" + super.toString() + ", length=" + length + ", position=" + " pozioma " + '}';
        } else {
            return "Window{" + super.toString() + ", length=" + length + ", position=" + " pionowa " + '}';
        }
    }

}
