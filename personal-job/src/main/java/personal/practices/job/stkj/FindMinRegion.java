package personal.practices.job.stkj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/17.
 */
public class FindMinRegion {

    static List<Integer[]> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer[]> intArrays = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Integer[] tmpArray = new Integer[n];
            for (int j = 0; j < n; j++) {
                tmpArray[j] = scanner.nextInt();
            }
            intArrays.add(tmpArray);
        }
        scanner.close();
        process(intArrays);
        int leftEdge = Integer.MAX_VALUE;
        int rightEdge = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer[] array : result) {
            Arrays.sort(array);
            int gap =array[array.length - 1] - array[0];
            if (gap <= min) {
                min = gap;
                if (array[0] < leftEdge) {
                    leftEdge = array[0];
                    rightEdge = array[array.length - 1];
                }
            }
        }
        System.out.println(leftEdge + " " + rightEdge);
    }

    private static void process(List<Integer[]> intArrays) {
        Integer[] array_1 = intArrays.get(0);
        for (Integer element : array_1) {
            Integer[] tmpResult = new Integer[intArrays.size()];
            int flag = element;
            tmpResult[0] = flag;
            result.add(tmpResult);
            for (int i = 1; i < intArrays.size(); i++) {
                flag = _process(intArrays, i, flag, tmpResult);
            }
        }
    }

    private static int _process(List<Integer[]> intArrays, int index, int flag, Integer[] result) {
        int gap = Integer.MAX_VALUE;
        int newFlag = 0;
        for (Integer element : intArrays.get(index)) {
            if (Math.abs(flag - element) < gap) {
                gap = Math.abs(flag - element);
                newFlag = element;
            } else {
                break;
            }
        }
        result[index] = newFlag;
        return newFlag;
    }
}
