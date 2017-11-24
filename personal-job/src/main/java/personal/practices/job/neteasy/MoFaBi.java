package personal.practices.job.neteasy;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/9.
 */
public class MoFaBi {

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magicCoinNumber = scanner.nextInt();
        scanner.close();
        calculate(magicCoinNumber);
        System.out.println(stringBuilder.reverse().toString());
    }

    public static void calculate(int coinNumber) {
        if (coinNumber == 0) {
            return;
        }
        if (coinNumber % 2 == 0) {
            stringBuilder.append("2");
            int remainNumber = (coinNumber - 2) / 2;
            calculate(remainNumber);
        } else {
            stringBuilder.append("1");
            int remainNumber = (coinNumber - 1) / 2;
            calculate(remainNumber);
        }
    }
}
