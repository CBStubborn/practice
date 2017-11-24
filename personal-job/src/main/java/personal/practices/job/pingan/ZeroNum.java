package personal.practices.job.pingan;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 要求：
 * 给定一个整数n，求这个数的阶乘末尾有多少个0
 * Created by Stubborn on 2017/10/11.
 */
public class ZeroNum {

    static int count = 0;

    static int zeroNum(int i) {
        int remain = i / 5;
        return remain + calculate(remain);
    }

    static int calculate(int n) {
        int remain = n / 5;
        count += remain;
        if (remain >= 5) {
            calculate(remain);
        }
        return count;
    }

    public static int getThe5times(int n) {
        //5的次数
        int times = 0;
        //如果数字小于5 直接返回0
        if (n < 5)
            return 0;
        //遍历5到n 之间的数
        for (int i = 5; i <= n; i++) {
            int num = i;
            //计算这个数包含5的个数
            while ((num % 5 == 0) && (num >= 5)) {
                num = num / 5;
                times++;
            }

        }
        return times;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int number = scanner.nextInt();
        scanner.close();
        int zeroNum = zeroNum(number);
        System.out.println(zeroNum);
        System.out.println(getThe5times(number));
    }

}
