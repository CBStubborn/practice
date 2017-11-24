package personal.practices.job.aiqiyi;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 要求;
 * 给定一个整型序列，在其连续子串中，最大值及次大值的异或结果为该子串的幸运值，
 * 求该整型序列的最大幸运值
 * Created by Stubborn on 2017/10/14.
 */
public class MaxLuckyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(scanner.nextInt());
        }
        scanner.close();
        System.out.println(process(stringBuilder.toString()));
    }

    private static int process(String str) {
        int maxLuckyNumber = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String sub = str.substring(i, j + 1);
                int max = Integer.MIN_VALUE;
                int nextMax = Integer.MIN_VALUE;
                System.out.println(sub);
                for (int k = 0; k < sub.length(); k++) {
                    int value = Integer.valueOf(String.valueOf(sub.charAt(k)));
                    if (k == 0) {
                        max = value;
                        continue;
                    }
                    if (value > max) {
                        nextMax = max;
                        max = value;
                    } else if (value < max && value > nextMax) {
                        nextMax = value;
                    }
                }
                if (nextMax == Integer.MIN_VALUE) {
                    nextMax = max;
                }
                int orValue = max ^ nextMax;
                if (orValue > maxLuckyNumber) {
                    maxLuckyNumber = orValue;
                }
                System.out.println(max + " " + nextMax);
            }
        }
        return maxLuckyNumber;
    }
}
