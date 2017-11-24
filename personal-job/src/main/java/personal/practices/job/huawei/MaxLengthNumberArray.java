package personal.practices.job.huawei;

import java.util.Scanner;

/**
 * 要求：
 * 给定一个字符串，输出字符串中最长的“数字串”
 * Created by Stubborn on 2017/9/9.
 */
public class MaxLengthNumberArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] arr = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        int max = 0;
        String maxSubString = "";
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j < arr.length && Character.isDigit(arr[j])) {
                builder.append(arr[j]);
                j++;
            }
            if (max < builder.length()) {
                max = builder.length();
                maxSubString = builder.toString();
            }
            i = j;
            builder.setLength(0);
        }
        System.out.println(maxSubString);
        System.out.println(max);
        scanner.close();
    }
}
