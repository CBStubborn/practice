package personal.practices.job.yamaxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/5.
 */
public class DiuShaBao {

    public static void main(String[] args) {
        List<Integer> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int guests = scanner.nextInt();
        for (int i = 1; i <= guests; i++) {
            personList.add(i);
        }
        process(personList, 0, 2);
        System.out.println(personList.get(0));
    }

    private static void process(List<Integer> personList, int nowPosition, int gap) {
        int tmpGap = gap;
        int length = personList.size();
        if (length == 1) {
            return;
        }
        while (nowPosition + tmpGap >= length) {
            tmpGap = tmpGap - (length - nowPosition);
            nowPosition = 0;
        }
        int eliminated = tmpGap + nowPosition;
        personList.remove(eliminated);
        process(personList, eliminated, gap);
    }
}
