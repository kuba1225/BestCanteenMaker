package dynamicstructures;

/**
 *
 * @author Kuba
 */
public class Matrix implements MatrixInterface {

    /**
     * Konstruktor tworz�cy macierz o podanych wymiarach.
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
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, zast�puj�c
     * znajduj�c� si� w niej wcze�niej zawarto��.
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
     * Metoda ta umieszcz obiekt w macierzy w podanym miejscu, dodaj�c podany
     * obiekt do zawarto�ci ju� znajduj�cej si� w podanym miejscu macierzy.
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
     * Metoda ta zwraca obiekt typu int znajduj�cy si� w podanym miejscu
     * macierzy.
     *
     * @param row numer wiersza macierzy z kt�rego chcemy pobra� warto��
     * @param column numer kolumny macierzy z kt�rego chcemy pobra� warto��
     * @return warto�� znajduj�ca si� pod podanymi wsp�rz�dnymi
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
     * Metoda ta zwraca liczb� kolumn w macierzy.
     *
     * @return liczba kolumn w macierzy
     */
    @Override
    public int getColumnNumber() {
        return cn;
    }

    /**
     * Metoda ta zwraca liczb� wierszy w macierzy.
     *
     * @return liczba wierszy w macierzy
     */
    @Override
    public int getRowNumber() {
        return rn;
    }

    /**
     * Metoda ta wype�nia ca�� macierz podan� warto�ci�
     *
     * @param obj warto�� jak� chcemy wype�ni� ca�� macierz
     */
    public void fillAllMatrix(int obj) {
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                matrix[i * cn + j] = obj;
            }
        }
    }

    /**
     * Metoda ta wype�nia podany obszar macierzy podan� warto�ci�
     *
     * @param obj warto�� jak� chcemy wype�ni� podany obszar macierzy
     * @param r1 wiersz od kt�rego chcemy rozpocz�� wype�nianie (w��cznie)
     * @param r2 wiersz na kt�rym chcemy zako�czy� wype�nianie (nie w��cznie)
     * @param c1 kolumna od kt�rej chcemy rozpocz�� wype�nianie (w��cznie)
     * @param c2 kolumna na kt�rej chcemy zako�czy� wype�nianie (nie w��cznie)
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
     * Metoda ta wypisuje ca�� macierz.
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
