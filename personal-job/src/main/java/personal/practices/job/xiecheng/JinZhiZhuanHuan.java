package personal.practices.job.xiecheng;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stubborn on 2017/9/21.
 */
public class JinZhiZhuanHuan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        process(m, n);
    }

    public static void process(int m, int n) {
        if (n == 10) {
            System.out.println(m);
            return;
        }
        boolean flag = true;
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = {'A', 'B', 'C', 'D', 'E', 'F'};
        while (m != 0) {
            if (m % n < 10) {
                stack.push(m % n + '0');
            } else {
                stack.push(m % n - 10 + 'A');
            }
            m = m / n;
        }
        while (!stack.isEmpty()) {
            if (m < 0 && flag) {
                stringBuilder.append("-");
                flag = false;
            }
            if (stack.peek() - '0' < 10) {
                stringBuilder.append(stack.pop() - '0');
            } else {
                stringBuilder.append(ch[stack.pop() - 'A']);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}

