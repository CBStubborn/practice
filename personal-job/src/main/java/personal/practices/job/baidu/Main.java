package personal.practices.job.baidu;

import java.util.*;

/**
 * Created by Stubborn on 2017/9/27.
 */
public class Main {

    static Map<Double, List<Integer>> map = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();


    }

    private static int process(List<List<Integer>> lists, int k) {
        int count = 0;
        Map<Integer, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            tmpMap.put(i, 0);
            double result = calculate(lists.get(i), 0);
            ++count;
            List<Integer> indexes = map.get(result);
            if (indexes == null) {
                indexes = new ArrayList<>();
                map.put(result, indexes);
            }
            indexes.add(i);
        }
        if (k < count) {
            //TODO 直接获取出结果

        } else {
            List<Integer> list = map.get(0);
        }
        return 00;
    }

    private static double calculate(List<Integer> list, int n) {
        return list.get(7) * Math.pow(n, 7) +
                list.get(6) * Math.pow(n, 6) +
                list.get(5) * Math.pow(n, 5) +
                list.get(4) * Math.pow(n, 4) +
                list.get(3) * Math.pow(n, 3) +
                list.get(2) * Math.pow(n, 2) +
                list.get(1) * Math.pow(n, 1) +
                list.get(0);
    }
}
