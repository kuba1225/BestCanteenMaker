package dynamicstructures;

/**
 *
 * @author Kuba
 */
public interface MatrixInterface {

    public void put(int obj, int row, int column);

    public void add(int obj, int row, int column);

    public int get(int row, int column);

    public int getColumnNumber();

    public int getRowNumber();
}
