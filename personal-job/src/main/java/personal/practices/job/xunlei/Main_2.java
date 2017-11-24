package personal.practices.job.xunlei;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 给定一个整数N，计算2的N次方的结果
 * Created by Stubborn on 2017/9/18.
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n;
        n = scanner.nextInt();
        scanner.close();
        BigInteger two = new BigInteger("2");
        BigInteger big = two.pow(n);
        System.out.println(big);
    }
}
