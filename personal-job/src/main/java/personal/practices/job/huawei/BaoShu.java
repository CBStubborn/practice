package personal.practices.job.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 要求：
 * n个人围成一圈，从第一个人开始报数，报到为M的人退出,接下来的人继续从1开始报数
 * 当剩余人数小于M时退出，输出剩余人数编号
 * Created by Stubborn on 2017/9/6.
 */
public class BaoShu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return;
        }
        scanner.close();
        List<Integer> persons = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            persons.add(i + 1);
        }
        process(persons, 0, m);
        for (int i = 0; i < persons.size(); i++) {
            System.out.print(persons.get(i));
            if (i < persons.size() - 1) {
                System.out.print(",");
            }
        }
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
