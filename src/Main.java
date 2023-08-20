import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws NumberFormatException
    {
        int num, size, sizeNum;
        try (Scanner sc = new Scanner(System.in))
        {
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
            int[][] matrix = new int[size][size];
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
                                if (matrix[i][j] > (sizeNum / 2) || matrix[i][j] < -(sizeNum / 2))
                                    System.out.println("Число вне диапазона! Введите число еще раз");
                            } while (matrix[i][j] > (sizeNum / 2) || matrix[i][j] < -(sizeNum / 2));
                        }
                    }
            }
            System.out.println("Заполненная матрица:");
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                    System.out.print(matrix[i][j] + "  ");
                System.out.println();
            }
        }
        catch (InputMismatchException exc)
        {
            System.out.println("Ошибка введённого типа, " + exc);
        }
    }
}
