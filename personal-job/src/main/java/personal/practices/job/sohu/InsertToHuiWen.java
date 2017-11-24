package personal.practices.job.sohu;

import java.util.Scanner;

/**
 * 给定一个数组，要求：
 * 往数组中插入一些数字，使得该数组成为回文串，并且该回文串所有数字和最小
 * Created by Stubborn on 2017/9/17.
 */
public class InsertToHuiWen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int originArray[] = new int[numbers];
        int sum = 0;
        for (int i = 0; i < numbers; i++) {
            originArray[i] = scanner.nextInt();
            sum += originArray[i];
        }
        scanner.close();
        int result = process(originArray, numbers, sum);
        System.out.println(result);
        //test(originArray, numbers, sum);
    }

    private static int process(int[] originArray, int numbers, int sum) {
        int dpArray[][] = new int[numbers + 1][numbers + 1];
        for (int i = 0; i < numbers; i++) {
            for (int j = 0; j < numbers; j++) {
                if (originArray[i] == originArray[numbers - j - 1]) {
                    dpArray[i + 1][j + 1] = dpArray[i][j] + originArray[i];
                } else {
                    if (dpArray[i][j + 1] > dpArray[i + 1][j]) {
                        dpArray[i + 1][j + 1] = dpArray[i][j + 1];
                    } else {
                        dpArray[i + 1][j + 1] = dpArray[i + 1][j];
                    }
                }
            }
        }
        return sum + (sum - dpArray[numbers][numbers]);
    }

    private static int test(int[] originArray, int numbers, int sum) {
        int dpArray[][] = new int[numbers + 1][numbers + 1];
        for (int i = 0; i < numbers; i++) {
            for (int j = 0; j < numbers; j++) {
                if (originArray[i] == originArray[numbers - j - 1]) {
                    dpArray[i + 1][j + 1] = dpArray[i][j] + 1;
                } else {
                    if (dpArray[i][j + 1] > dpArray[i + 1][j]) {
                        dpArray[i + 1][j + 1] = dpArray[i][j + 1];
                    } else {
                        dpArray[i + 1][j + 1] = dpArray[i + 1][j];
                    }
                }
            }
        }
        for(int i =0; i < numbers + 1; i ++) {
            for(int j = 0; j < numbers + 1; j ++) {
                System.out.print(dpArray[i][j] + " ");
            }
            System.out.println();
        }
        return sum + (sum - dpArray[numbers][numbers]);
    }

}
