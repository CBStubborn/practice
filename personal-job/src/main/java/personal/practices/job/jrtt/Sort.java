package personal.practices.job.jrtt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Stubborn on 2017/10/27.
 */
public class Sort {

    public static void sort(int[] array) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack();
        stack.push(Integer.MAX_VALUE);
        for (int i = 0; i < array.length; i++) {
            if (i / 2 == 0) {
                queue.add(array[i]);
            } else {
                stack.push(array[i]);
            }
        }
        queue.add(Integer.MAX_VALUE);
        Integer qv = queue.poll();
        Integer sv = stack.pop();
        int index = 0;
        do {
            if (qv > sv) {
                array[index] = sv;
                index++;
                sv = stack.pop();
            } else if (qv <= sv) {
                array[index] = qv;
                index++;
                qv = queue.poll();
            }
        } while (qv != null && sv != null);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 3, 8, 5, 6, 7, 4, 9, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
