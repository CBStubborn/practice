package personal.practices.job.yamaxun;

import java.util.*;

/**
 * Created by Stubborn on 2017/9/5.
 */
public class CakeChoice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int m = Integer.valueOf(scanner.nextLine());
        int k = Integer.valueOf(scanner.nextLine());
        Map<Integer, Integer> fruitCountMap = new TreeMap<>();
        List<List<Integer>> favourites = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> tmpList = new ArrayList<>();
            String line = scanner.nextLine();
            String[] pieces = line.split(" ");
            for (String piece : pieces) {
                int favourite = Integer.valueOf(piece);
                if (favourite > 0 && favourite <= n * m) {
                    Integer count = fruitCountMap.get(favourite);
                    if (count == null) {
                        count = 0;
                    }
                    count = count + 1;
                    fruitCountMap.put(favourite, count);
                    tmpList.add(favourite);
                }
            }
            favourites.add(tmpList);
        }


    }
}
