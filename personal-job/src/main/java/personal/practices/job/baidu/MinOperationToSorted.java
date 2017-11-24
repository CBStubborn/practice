package personal.practices.job.baidu;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 * <p>
 * 解题思路：
 * 首先判断原数组是否有序，如果有序则返回0， 否则：
 * 将原数组排序，然后一次比较，找出排序后的数组与原数组中，从小到大相同的子序列，除此之外
 * 的其他元素每个移动一次即可。
 * </p>
 * Created by Stubborn on 2017/9/19.
 */
public class MinOperationToSorted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] originArray = new int[n];
        for (int i = 0; i < n; i++) {
            originArray[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(process(originArray));
    }

    private static int process(int[] originArray) {
        int[] copyArray = Arrays.copyOf(originArray, originArray.length);
        Arrays.sort(originArray);
        if (Arrays.equals(copyArray, originArray)) {
            return 0;
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < originArray.length; i++) {
            boolean isFound = false;
            int j = index;
            for (; j < copyArray.length; j++) {
                if (copyArray[j] == originArray[i]) {
                    index = j + 1;
                    count++;
                    isFound = true;
                }
            }
            if (!isFound && j == originArray.length) {
                break;
            }
        }
        return originArray.length - count;
    }

}
