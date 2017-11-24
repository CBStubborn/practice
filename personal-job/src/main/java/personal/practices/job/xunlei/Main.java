package personal.practices.job.xunlei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 要求：
 * 输入一个整数n，计算从2到5进制的所有位数的和
 * Created by Stubborn on 2017/9/18.
 */
public class Main {

    static int[] x = {2, 3, 4, 5};

    public static int getSum(int n, int xx) {
        int sum = 0;
        while (n != 0) {
            sum += n % xx;
            n = n / xx;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n;
        n = scanner.nextInt();
        scanner.close();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += getSum(n, x[i]);
        }
        System.out.println(sum);
    }
}
