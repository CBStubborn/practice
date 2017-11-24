package personal.practices.job.didi;


import java.util.Scanner;

/**
 * 题目要求：
 * 输出第N个丑数
 * Created by Stubborn on 2017/9/10.
 */
public class UglyNumber {

    public int getMin(int number1, int number2, int number3) {
        int min = number1;
        if (number2 < min) {
            min = number2;
        }
        if (number3 < min) {
            min = number3;
        }
        return min;
    }

    public int getUglyNumber(int index) {
        if (index < 0) {
            return 0;
        }
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int multiply_2 = 0;
        int multiply_3 = 0;
        int multiply_5 = 0;
        for (int i = 1; i < index; i++) {
            int min = getMin(uglyArray[multiply_2] * 2, uglyArray[multiply_3] * 3, uglyArray[multiply_5] * 5);
            uglyArray[i] = min;
            while (uglyArray[multiply_2] * 2 == uglyArray[i]) {
                multiply_2++;
            }
            while (uglyArray[multiply_3] * 3 == uglyArray[i]) {
                multiply_3++;
            }
            while (uglyArray[multiply_5] * 5 == uglyArray[i]) {
                multiply_5++;
            }
        }
        return uglyArray[index - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.close();
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.getUglyNumber(index));
    }

}
