package dynamicstructures;

/**
 *
 * @author Kuba
 */
public class Matrix implements MatrixInterface {

    /**
     * Konstruktor tworzący macierz o podanych wymiarach.
     *
     * @param rn liczba wierszy
     * @param cn liczba kolumn
     */
    public Matrix(int rn, int cn) {
        this.rn = rn;
        this.cn = cn;
        matrix = new int[rn * cn];
    }

    private int cn = 0;//liczba kolumn w macierzy
    private int rn = 0;//liczba wierszy w macierzy

    private int[] matrix;//tablica do przechowywania macierzy asdasd asd

    /**
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, zastępując
     * znajdującą się w niej wcześniej zawartość.
     *
     * @param obj obiekt wstawiany do macierzy
     * @param row numer wiersza
     * @param column numer kolumny
     */
    @Override
    public void put(int obj, int row, int column) {
        if (column >= 0 && column < cn && row >= 0 && row < rn) {
            matrix[row * cn + column] = obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, dodając podany
     * obiekt do zawartości już znajdującej się w podanym miejscu macierzy.
     *
     * @param obj obiekt wstawiany do macierzy
     * @param row numer wiersza
     * @param column numer kolumny
     */
    @Override
    public void add(int obj, int row, int column) {
        if (column >= 0 && column < cn && row >= 0 && row < rn) {
            matrix[row * cn + column] += obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Metoda ta zwraca obiekt typu int znajdujący się w podanym miejscu
     * macierzy.
     *
     * @param row numer wiersza macierzy z którego chcemy pobrać wartość
     * @param column numer kolumny macierzy z którego chcemy pobrać wartość
     * @return wartość znajdująca się pod podanymi współrzędnymi
     */
    @Override
    public int get(int row, int column) {
        if (column >= 0 && column < cn && row >= 0 && row < rn) {
            return matrix[row * cn + column];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Metoda ta zwraca liczbę kolumn w macierzy.
     *
     * @return liczba kolumn w macierzy
     */
    @Override
    public int getColumnNumber() {
        return cn;
    }

    /**
     * Metoda ta zwraca liczbę wierszy w macierzy.
     *
     * @return liczba wierszy w macierzy
     */
    @Override
    public int getRowNumber() {
        return rn;
    }

    /**
     * Metoda ta wypełnia całą macierz podaną wartością
     *
     * @param obj wartość jaką chcemy wypełnić całą macierz
     */
    public void fillAllMatrix(int obj) {
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                matrix[i * cn + j] = obj;
            }
        }
    }

    /**
     * Metoda ta wypełnia podany obszar macierzy podaną wartością
     *
     * @param obj wartość jaką chcemy wypełnić podany obszar macierzy
     * @param r1 wiersz od którego chcemy rozpocząć wypełnianie (włącznie)
     * @param r2 wiersz na którym chcemy zakończyć wypełnianie (nie włącznie)
     * @param c1 kolumna od której chcemy rozpocząć wypełnianie (włącznie)
     * @param c2 kolumna na której chcemy zakończyć wypełnianie (nie włącznie)
     */
    public void fillAreaInMatrix(int obj, int r1, int r2, int c1, int c2) {
        if (c1 >= 0 && c1 < cn && c2 >= 0 && c2 <= cn && r1 >= 0 && r1 < rn && r2 >= 0 && r2 <= rn) {
            for (int i = r1; i < r2; i++) {
                for (int j = c1; j < c2; j++) {
                    matrix[i * cn + j] = obj;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Metoda ta wypisuje całą macierz.
     */
    public void writeMatrix() {
        for (int i = 0; i < rn; i++) {
            System.out.print("[");
            for (int j = 0; j < cn; j++) {
                System.out.print(matrix[i * cn + j]);
                if (j < cn - 1) {
                    System.out.print("  ");
                }
            }
            System.out.print("]\n");
        }
    }

}
