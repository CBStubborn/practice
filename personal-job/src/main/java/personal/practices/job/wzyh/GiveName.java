package personal.practices.job.wzyh;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/10/26.
 * 给商店起名字
 */
public class GiveName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str_1 = scanner.nextLine();
        String str_2 = scanner.nextLine();
        scanner.close();
        if (getMaxSubstringLen(str_1, str_2) >= str_1.length() / 2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int getMaxSubstringLen(String x, String y) {
        int xLen = x.length() + 1;
        int yLen = y.length() + 1;
        int rLen = xLen > yLen ? xLen : yLen;
        int cLen = xLen < yLen ? xLen : yLen;
        int[][] c = new int[rLen][cLen];
        for (int i = 1; i < rLen; i++) {
            for (int j = 1; j < cLen; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
        return c[xLen - 1][yLen - 1];
    }

}
