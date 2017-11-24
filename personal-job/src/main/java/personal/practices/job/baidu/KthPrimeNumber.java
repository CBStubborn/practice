package personal.practices.job.baidu;

import java.util.Scanner;

/**
 * 获取第K个双素数.
 * 双素数: 一个数是素数，并且将该数倒转后，与原值不等且为素数
 * Created by Stubborn on 2017/9/27.
 */
public class KthPrimeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.close();
        System.out.println(getKthDePrimeNumber(k));
    }

    private static int getKthDePrimeNumber(int k) {
        int i = 0;
        int flag = 13;
        while (true) {
            for (int j = flag; j < Integer.MAX_VALUE; j = j + 2) {
                if (isDePrimeNumber(j)) {
                    ++i;
                    flag = j + 2;
                    break;
                }
            }
            if (i == k) {
                break;
            }
        }
        return flag - 2;
    }

    private static boolean isDePrimeNumber(int number) {
        String convert = new StringBuilder(String.valueOf(number)).reverse().toString();
        int convertNumber = Integer.valueOf(convert);
        if (number != convertNumber) {
            if (isPrime(number) && isPrime(convertNumber)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
