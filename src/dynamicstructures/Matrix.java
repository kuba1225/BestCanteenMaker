package dynamicstructures;

/**
 *
 * @author Kuba
 */
public class Matrix implements MatrixInterface {

    /**
     * Konstruktor tworz¹cy macierz o podanych wymiarach.
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
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, zastêpuj¹c
     * znajduj¹c¹ siê w niej wczeœniej zawartoœæ.
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
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, dodaj¹c podany
     * obiekt do zawartoœci ju¿ znajduj¹cej siê w podanym miejscu macierzy.
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
     * Metoda ta zwraca obiekt typu int znajduj¹cy siê w podanym miejscu
     * macierzy.
     *
     * @param row numer wiersza macierzy z którego chcemy pobraæ wartoœæ
     * @param column numer kolumny macierzy z którego chcemy pobraæ wartoœæ
     * @return wartoœæ znajduj¹ca siê pod podanymi wspó³rzêdnymi
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
     * Metoda ta zwraca liczbê kolumn w macierzy.
     *
     * @return liczba kolumn w macierzy
     */
    @Override
    public int getColumnNumber() {
        return cn;
    }

    /**
     * Metoda ta zwraca liczbê wierszy w macierzy.
     *
     * @return liczba wierszy w macierzy
     */
    @Override
    public int getRowNumber() {
        return rn;
    }

    /**
     * Metoda ta wype³nia ca³¹ macierz podan¹ wartoœci¹
     *
     * @param obj wartoœæ jak¹ chcemy wype³niæ ca³¹ macierz
     */
    public void fillAllMatrix(int obj) {
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                matrix[i * cn + j] = obj;
            }
        }
    }

    /**
     * Metoda ta wype³nia podany obszar macierzy podan¹ wartoœci¹
     *
     * @param obj wartoœæ jak¹ chcemy wype³niæ podany obszar macierzy
     * @param r1 wiersz od którego chcemy rozpocz¹æ wype³nianie (w³¹cznie)
     * @param r2 wiersz na którym chcemy zakoñczyæ wype³nianie (nie w³¹cznie)
     * @param c1 kolumna od której chcemy rozpocz¹æ wype³nianie (w³¹cznie)
     * @param c2 kolumna na której chcemy zakoñczyæ wype³nianie (nie w³¹cznie)
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
     * Metoda ta wypisuje ca³¹ macierz.
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
