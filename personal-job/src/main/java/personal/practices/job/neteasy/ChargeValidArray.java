package personal.practices.job.neteasy;

import java.util.*;

/**
 * Created by Stubborn on 2017/9/9.
 */
public class ChargeValidArray {

    public static Map<Integer, List<Integer>> numberValidListMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayNumber = Integer.valueOf(scanner.nextLine());
        List<List<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < arrayNumber; i++) {
            int arraySize = Integer.valueOf(scanner.nextLine());
            String[] array = scanner.nextLine().split(" ");
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < arraySize; j++) {
                tmpList.add(Integer.valueOf(array[j]));
            }
            arrayList.add(tmpList);
        }
        scanner.close();
        for (int k = 0; k < arrayList.size(); k++) {
            boolean valid = process(arrayList.get(k));
            if(valid) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean process(List<Integer> originArray) {

        for (int i = 0; i < originArray.size(); i++) {
            int number = originArray.get(i);
            for (int j = 0; j < originArray.size(); j++) {
                if (j == i) {
                    continue;
                }
                int chargeNumber = originArray.get(j);
                if (number * chargeNumber % 4 == 0) {
                    List<Integer> validList = numberValidListMap.get(number);
                    if (validList == null) {
                        validList = new ArrayList<>();
                        numberValidListMap.put(number, validList);
                    }
                    validList.add(chargeNumber);
                }
            }
        }
        if (numberValidListMap.size() == 0) {
            return false;
        }

        List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(numberValidListMap.entrySet());
        System.out.println(entries.size());
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < entries.size(); i++) {
            int validSize = entries.get(i).getValue().size();
            if (validSize < min) {
                min = validSize;
                minIndex = i;
            }
        }
        Map.Entry<Integer, List<Integer>> entry = entries.get(minIndex);
        List<Integer> validList = entry.getValue();
        originArray.remove(entry.getKey());
        _process(validList, originArray);
        if (originArray.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void _process(List<Integer> validList, List<Integer> originArray) {
        for (int i = 0; i < validList.size(); i++) {
            List<Integer> tmpList = numberValidListMap.get(validList.get(i));
            if (tmpList != null) {
                if (originArray.contains(validList.get(i))) {
                    originArray.remove(validList.get(i));
                    _process(tmpList, originArray);
                }
            }
        }
    }
}
