package personal.practices.job.xiaomi;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 要求：
 * 兔子从A地到B地，当中每1公里有一个休息站，兔子体力每次最多可连续行走2公里，
 * 也就是说兔子可以选择行走1公里或者2公里休息一次，然后继续行走。假设A地距离B地
 * N公里，求兔子的行走休息方案有多少种
 * 解答：
 * 这就是一个斐波那契数列
 * Created by Stubborn on 2017/9/18.
 */
public class Rabbit {

    public static void main(String[] args) {
        int[] fibArray = generateFibArray();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            System.out.println(fibArray[n]);
        }
        scanner.close();
    }

    private static int[] generateFibArray() {
        int[] fibArray = new int[1000000];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < 1000000; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

}
