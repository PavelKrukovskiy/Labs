import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите порядок матрицы: ");
        int n = sc.nextInt();

        Integer[][] matr_n = new Integer[n][n];
        Integer[][] matr_n_1 = new Integer[n - 1][n - 1];
        int max_abs = randmatr(matr_n, n);

        newmatr(matr_n, matr_n_1, n, max_abs);
        System.out.println("Новая матрица");
        printmatr(matr_n_1);
        System.out.println("Отфораматированная матрица");
        printformatmatr(matr_n_1);
        printmatrinproc(matr_n_1);
        System.out.println("Матрица с отсортированной последней строкой");
        Arrays.sort(matr_n_1[n - 2], new MyComparator());
        printmatr(matr_n_1);
        System.out.print("Введите элемент, который хотите найти в последней строке: ");
        int nn = sc.nextInt();
        nn = Arrays.binarySearch(matr_n_1[n - 2], nn, new MyComparator());
        if (nn < 0)
            System.out.println("Такого элемента нет");
        else
            System.out.println("Индекс элемента: " + (nn+1));
    }


    public static class C1 implements Comparator {

        public int compare(Object obj1, Object obj2) {
            if (obj1 instanceof Integer && obj2 instanceof Integer) {
                int o1 = ((Integer) obj1).intValue();
                int o2 = ((Integer) obj2).intValue();
                if (o1 < o2) return -1;
                if (o1 == o2) return 0;
                else return 1;
            }
            return -1;
        }

    }


    public static void newmatr(Integer[][] oldmatr, Integer[][] newmatr, int n, int max_abs) {
        int row = -1, column = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(oldmatr[i][j]) == max_abs) {
                    row = i;
                    column = j;
                    break;
                }
            }
            if (column != -1)
                break;
        }
        int j = oldmatr[0].length;
        for (int i = 0; i < row; i++) {
            System.arraycopy(oldmatr[i], 0, newmatr[i], 0, column);
            System.arraycopy(oldmatr[i], column + 1, newmatr[i], column, j - column - 1);
        }
        for (int i = row + 1; i < j; i++) {
            System.arraycopy(oldmatr[i], 0, newmatr[i - 1], 0, column);
            System.arraycopy(oldmatr[i], column + 1, newmatr[i - 1], column, j - column - 1);
        }
    }

    public static void masc(int[] masfrom, int[] masc, int n) {
        System.arraycopy(masfrom, 0, masc, 0, n);
        System.arraycopy(masfrom, n + 1, masc, n, masc.length - n);
    }

    public static int randmatr(Integer[][] matr_n, int n) {
        Random r = new Random();
        int max_abs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //matr_n[i][j]=r.nextInt(2)+12;
                matr_n[i][j] = r.nextInt(201) - 100;
                if (max_abs < Math.abs(matr_n[i][j])) {
                    max_abs = Math.abs(matr_n[i][j]);
                }
                System.out.print(matr_n[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Максимальный по модулю элемент: " + max_abs);
        return max_abs;
    }

    public static void printmatr(Integer[][] matr_n) {

        for (int i = 0; i < matr_n.length; i++) {
            for (int j = 0; j < matr_n[i].length; j++) {
                System.out.print(matr_n[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printformatmatr(Integer[][] matr_n) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        //formatter.setMinimumIntegerDigits(3);
        for (int i = 0; i < matr_n.length; i++) {
            for (int j = 0; j < matr_n[i].length; j++) {
                System.out.print(formatter.format(matr_n[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printmatrinproc(Integer[][] matr_n)
    {
        NumberFormat numberFormat5 = NumberFormat.getPercentInstance();
        System.out.println("Элементы матрицы в процентном виде");
        for(int i=0; i<matr_n.length;i++)
        {
            for(int j=0;j<matr_n[i].length;j++)
            {
                System.out.print(numberFormat5.format(matr_n[i][j])+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}


