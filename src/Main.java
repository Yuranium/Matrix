import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{
    public static int[][] matrixFunc(Scanner sc) throws NumberFormatException
    {
        int num, size, sizeNum;
        int[][] matrix;
        System.out.print("Введите диапазон чисел в матрице: ");
        sizeNum = sc.nextInt();
        if (sizeNum < 0)
            sizeNum = -sizeNum;
        do
        {
            System.out.print("Введите размер матрицы: ");
            size = sc.nextInt();
            if (size > 10 || size < 0)
                System.out.println("Ошибка ввода размера");
        } while (size > 10 || size < 0);
        matrix = new int[size][size];
        do
        {
            System.out.println("Заполнение матрицы: 1 - автоматически; 2 - вручную");
            num = sc.nextInt();
            if (num > 2 || num <= 0)
                System.out.println("Недопустимый диапазон выбора!");
        } while (num > 2 || num <= 0);
        switch (num)
        {
            case 1:
                for (int i = 0; i < size; i++)
                {
                    for (int j = 0; j < size; j++)
                        matrix[i][j] = (int) ((Math.random() * sizeNum) - (sizeNum / 2));
                }
                break;
            case 2:
                for (int i = 0; i < size; i++)
                {
                    for (int j = 0; j < size; j++)
                    {
                        do
                        {
                            System.out.println("Ввод числа с индексами: [" + i + "][" + j + "]");
                            matrix[i][j] = sc.nextInt();
                            if (matrix[i][j] > sizeNum || matrix[i][j] < -sizeNum)
                                System.out.println("Число вне диапазона! Введите число еще раз");
                        } while (matrix[i][j] > sizeNum || matrix[i][j] < -sizeNum);
                    }
                }
        }
        return matrix;
    }
    public static int DetMatrix(int[][] matrix)
    {
        if (matrix.length == 1)
            return matrix[0][0];
        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int len = matrix.length;
        int[][] mx = new int[len - 1][len - 1];
        int determinant = 0, a, b;
        for (int i = 0; i < len; i++)
        {
            a = 0;
            for (int j = 1; j < len; j++)
            {
                b = 0;
                for (int k = 0; k < len; k++)
                {
                    if (i != k)
                        mx[a][b++] = matrix[j][k];
                }
                a++;
            }
            determinant += matrix[0][i] * (int) (Math.pow(-1, (i + 2))) * DetMatrix(mx);
        }
        return determinant;
    }
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in))
        {
            int[][] matrix = matrixFunc(sc);
            System.out.println("Заполненная матрица:");
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix.length; j++)
                    System.out.print(matrix[i][j] + "  ");
                System.out.println();
            }
            System.out.println("Вывести определитель данной матрицы?\n 1 - Да; 2... - Нет");
            int bf = sc.nextInt();
            if (bf == 1)
                System.out.println("Определитель данной матрицы равен: " + DetMatrix(matrix));
        }
        catch (InputMismatchException exc)
        {
            System.out.println("Ошибка введённого типа: " + exc);
            System.exit(1);
        }
    }
}
