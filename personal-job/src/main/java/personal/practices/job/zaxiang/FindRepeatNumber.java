package personal.practices.job.zaxiang;

import java.util.BitSet;

/**
 * Created by CBStubborn on 2017/11/14.
 */
public class FindRepeatNumber {

    /**
     * 要求：假设你有一个用 n + 1个整数组成的数组，这些整数是任意排列的，但是你知道所有的整数都在1到n(包括n)之间。
     * 此外，除一个数字出现两次外，其他所有数字只出现一次。假设你只能对这个数组做一次处理，用一种算法找出重复的那个数字。
     * 解题思路：
     * 假设n为1000
     * 数组中的1001个数相互异或的结果与（1-1000）相互异或的结果再做异或，得出的值即位所求
     * 原理：
     * 假设重复数为A，其余999个数相互异或结果为B。
     * 那么1-1000异或结果为A^B；
     * 1001个数异或结果为A^(A^B) 。
     * 由于异或满足交换律和结合律，且X^X = 0， 0^X = X；
     * 则有：A^(A^B)  = B ；(A^B)^B=A。
     * A即为所求
     *
     * @param array
     * @param n
     * @return
     */
    public static int getRepeatNumber(int[] array, int n) {
        int result = 0;
        // A^(A^B)
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        //A^(A^B)^(A^B) = A
        for (int i = 1; i <= n; i++) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 5};
        int result = getRepeatNumber(array, 5);
        System.out.println(result);
    }

}
