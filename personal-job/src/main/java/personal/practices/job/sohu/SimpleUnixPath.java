package personal.practices.job.sohu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stubborn on 2017/9/17.
 */
public class SimpleUnixPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();
        String result = process(inputLine);
        System.out.println(result);
    }

    private static String process(String inputLine) {
        String[] operation = inputLine.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < operation.length; i++) {
            if ("..".equals(operation[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ((!"".equals(operation[i])) && (!".".equals(operation[i]))) {
                stack.push(operation[i]);
            }
        }
        String result = "";
        if (stack.isEmpty()) {
            result = "/";
        } else {
            while (!stack.isEmpty()) {
                result = "/" + stack.pop() + result;
            }
        }
        return result;
    }
}
