package personal.practices.job.huawei;

import java.util.Scanner;

/**
 * 要求：
 * 酒店有n个龙头用于接酒，。。。。
 * Created by Stubborn on 2017/9/9.
 */
public class GetWinTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x[] = new int[m];
        int time = 0;
        for (int i = 0; i < n; i++) {
            int wi = scanner.nextInt();
            System.out.println("wi: " + wi);
            int x0 = x[0];
            time += x0;
            int index = -1;
            for (int j = 1; j < m; j++) {
                x[j] -= x0;
                if (wi > x[j]) {
                    x[j - 1] = x[j];
                } else {
                    if (index == -1) {
                        index = j - 1;
                    }
                }
            }
            System.out.println("index: " + index);
            if (index == -1) {
                index = m - 1;
            }
            x[index] = wi;
        }
        scanner.close();
        System.out.println(time + x[m - 1]);
    }
}
