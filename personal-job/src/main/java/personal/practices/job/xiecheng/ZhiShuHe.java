package personal.practices.job.xiecheng;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/21.
 */
public class ZhiShuHe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        scanner.close();
        int count = 0;
        for (int i = 1; i < n; i = i + 2) {
            if (isPrime(i) && isPrime(n - i)) {
                count++;
            }
        }
        if (isPrime(n / 2)) {
            count++;
        }
        System.out.println(count / 2);
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
