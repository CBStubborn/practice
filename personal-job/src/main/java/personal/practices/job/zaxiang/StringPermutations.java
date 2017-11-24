package personal.practices.job.zaxiang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stubborn on 2017/10/24.
 */
public class StringPermutations {

    public static void main(String[] args) {
        printPermutation("abc", "");
        List<String> results = getSubsets("abc");
        for (String result : results) {
            System.out.println(result);
        }
    }

    /**
     * 打印输出给定字符串所有可能的排列组合，假设没有重复字符，
     * 例如：字符串abc所有可能的排列组合为：
     * abc, acb, bac, bca, cab, cba
     * 即A(n, n)
     */
    public static void printPermutation(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
        } else {
            for (int i = 0; i < str.length(); ++i) {
                printPermutation(str.substring(0, i) + str.substring(i + 1, str.length()), result + str.charAt(i));
            }
        }
    }

    /**
     * 打印给定字符串所有可能的子集，假设没有重复字符,例如：
     * 字符串 abc 所有的子集为：
     * a, b, c, ab, bc, ac, abc
     * 解题思路：
     * 对于集合里面的任何一个元素，有两种可能，一种是在子集合里，另一种是不在子集合里。
     * 在子集合里的话用1表示，不在的话用0表示，即可用二进制表示
     *
     * @param str
     */
    static List<String> getSubsets(String str) {
        List results = new ArrayList<String>();
        int max = 1 << str.length(); //how many sub sets
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < max; i++) { // i start from 0 if needs empty subset
            int index = 0;
            int k = i;
            while (k > 0) {
                if ((k & 1) > 0) {
                    sb.append(str.charAt(index));
                }
                k >>= 1;
                index++;
            }
            results.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return results;
    }

}