package personal.practices.job.yjny;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/17.
 */
public class BaoShu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        List<Integer> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            persons.add(i + 1);
        }
        process(persons, 0, m);
        System.out.println(persons.get(0));
    }

    public static void process(List<Integer> persons, int nowPosition, int gap) {
        int tmpGap = gap - 1;
        int length = persons.size();
        if (length < gap) {
            return;
        }
        while (nowPosition + tmpGap >= length) {
            tmpGap = tmpGap - (length - nowPosition);
            nowPosition = 0;
        }
        int eliminated = tmpGap + nowPosition;
        persons.remove(eliminated);
        process(persons, eliminated, gap);
    }
}
