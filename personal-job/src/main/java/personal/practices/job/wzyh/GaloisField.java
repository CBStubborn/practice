package personal.practices.job.wzyh;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/10/26.
 */
public class GaloisField {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                cnt += Math.log(n) / Math.log(i);
            }
        }
        System.out.println(cnt);
    }

    public static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

}

