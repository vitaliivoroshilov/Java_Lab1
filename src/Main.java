import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число монстров N:");
        int N = scanner.nextInt();
        System.out.println("Введите количество жизней за 1 выстрел k: ");
        int k = scanner.nextInt();

        Random random = new Random();
        int[] arr = new int[N];
        int minValue = 10, maxValue = 100;
        for (int i = 0; i < N; i++)
            arr[i] = minValue + Math.abs(random.nextInt()) % (maxValue - minValue + 1);

        int iMax = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[iMax])
                iMax = i;

        while (arr[iMax] > 0) {

            for (int i = 0; i < iMax; i++)
                System.out.print(arr[i] + " ");

            System.out.print(arr[iMax] + "* ");
            arr[iMax] -= k;
            int iDead = -1;
            if (arr[iMax] <= 0)
                iDead = iMax;

            for (int i = iMax + 1; i < N; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
            if (iDead >= 0)
                System.out.println("Монстр " + iDead + " убит!");

            iMax = 0;
            for (int i = 1; i < N; i++)
                if (arr[i] > arr[iMax])
                    iMax = i;
        }
        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
    }

}