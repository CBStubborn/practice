package personal.practices.job.neteasy;

import java.util.*;

/**
 * Created by Stubborn on 2017/8/29.
 */
public class ArrayConvert {

    private static List<Integer> list = new ArrayList();

    private static Stack<Integer> stack = new Stack();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        //process(input);
        validMethod(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb.toString().trim());
    }

    /**
     * 此方法超过时间限制（2秒）
     *
     * @param originArray
     */
    public static void process(int[] originArray) {
        for (int i = 0; i < originArray.length; i++) {
            list.add(originArray[i]);
            int size = list.size();
            for (int j = 0; j < size; j++) {
                stack.push(list.get(j));
            }
            list.clear();
            for (int k = 0; k < size; k++) {
                list.add(stack.pop());
            }
        }
    }

    /**
     * 此方法有效
     *
     * @param originArray
     */
    public static void validMethod(int[] originArray) {
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < originArray.length; i++) {
            tmpList.add(originArray[i]);
        }
        for (int i = tmpList.size() - 1; i >= 0; i = i - 2) {
            list.add(tmpList.get(i));
        }
        if (tmpList.size() % 2 == 0) {
            for (int i = 0; i < tmpList.size(); i = i + 2) {
                list.add(tmpList.get(i));
            }
        } else {
            for (int i = 1; i < tmpList.size(); i = i + 2) {
                list.add(tmpList.get(i));
            }
        }
    }
}
