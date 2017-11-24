package personal.practices.job.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述：
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 * Created by Stubborn on 2017/8/31.
 */
public class MoveChar {

    public static void main(String[] args) {
        List<char[]> arrays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (inputLine.trim().length() == 0) {
                break;
            }
            char[] chars = inputLine.toCharArray();
            arrays.add(chars);
        }
        for (char[] chars : arrays) {
            move(chars);
            System.out.println(chars);
        }

    }

    /**
     * 此方法返回结果中，大写字母在末尾按照原来相反的顺序排列
     *
     * @param array
     * @return
     */
    public static void reverseMove(char[] array) {
        int length = array.length;
        for (int i = 0; i < length; ) {
            char element = array[i];
            if (!Character.isLowerCase(element)) {
                for (int j = i + 1; j < length; j++) {
                    array[j - 1] = array[j];
                }
                array[length - 1] = element;
                length--;
            } else {
                i++;
            }
        }
    }

    /**
     * 此方法返回的结果中，大写字母在末尾按照原来顺序排列
     *
     * @param array
     * @return
     */
    public static void move(char[] array) {
        int length = array.length;
        for (int i = 0; i < length; ) {
            char element = array[i];
            if (!Character.isLowerCase(element)) {
                for (int j = i + 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 1] = element;
                length--;
            } else {
                i++;
            }
        }
    }
}
