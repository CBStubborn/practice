package personal.practices.job.zaxiang;

import java.util.Stack;


/**
 * Created by Stubborn on 2017/9/21.
 */
public class KuoHaoPiPei {

    public static void main(String[] args) {
        System.out.println(process("))))UUUU((()"));
    }

    /**
     * 要求：
     * 在某个字符串（长度不超过100）中有左括号、右括号和大小写字母；
     * 规定（与常见的算数式子一样）任何一个左括号都从内到外与在它右边且距离最近的右括号匹配。
     * 写一个程序，找到无法匹配的左括号和右括号，输出原来字符串，并在下一行标出不能匹配的括号。
     * 不能匹配的左括号用"$"标注,不能匹配的右括号用"?"标注。
     * 例如：
     * 输入：
     * bge)))))))))
     * ((IIII))))))
     * ()()()()(uuu
     * ))))UUUU((()
     * 对应输出：
     * bge)))))))))
     * ?????????
     * ((IIII))))))
     * ????
     * ()()()()(uuu
     * $
     * ))))UUUU((()
     * ????    $$
     *
     * @param originStr
     */
    private static String process(String originStr) {
        Stack<Integer> stack = new Stack();
        char[] chars = originStr.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                stack.push(i);
                result.append(' ');
            } else if (')' == chars[i]) {
                if (stack.isEmpty()) {
                    result.append('?');
                } else {
                    result.append(' ');
                    stack.pop();
                }
            } else {
                result.append(' ');
            }
        }
        while (!stack.isEmpty()) {
            result.setCharAt(stack.peek(), '$');
            stack.pop();
        }
        return result.toString();
    }
}
