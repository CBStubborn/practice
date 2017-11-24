package personal.practices.job.wzyh;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/10/26.
 */

public class WordSummary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String str = scanner.next();
            if (str.length() > 10) {
                str = "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
            }
            System.out.println(str);
        }
        scanner.close();
    }

}

