package personal.practices.job.neteasy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题描述：
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,
 * 我们就称数列S为等差数列。小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。
 * 小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。
 * 但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作
 * 变成等差数列
 * Created by Stubborn on 2017/8/29.
 */
public class DengChaShuLie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        System.out.println(n);
        String line = scanner.nextLine();
        System.out.println(line);
        String[] numberStrings = line.split(" ");
        int[] numbers = new int[numberStrings.length];
        for(int i =0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(numberStrings[i]);
        }
        Arrays.sort(numbers);
        int distance = 0;
        for(int i = 1; i < numbers.length; i++) {
            if(i == 1) {
                distance = numbers[i] - numbers[i - 1];
            } else {
                if(distance != numbers[i] - numbers[i - 1]) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        System.out.println("Possible");
    }
}
