package personal.practices.job.meituan;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/14.
 */
public class ConvertBulb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int originArray[] = new int[n];
        for (int i = 0; i < n; i++) {
            originArray[i] = scanner.nextInt();
        }
        scanner.close();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (originArray[i] == 1) {
                for (int j = i; j < n; j++) {
                    if (originArray[j] == 1) {
                        originArray[j] = 0;
                    } else {
                        originArray[j] = 1;
                    }
                }
                count++;
            }
        }
        if (count % 2 == 0 && count != 0) {
            System.out.println("Bob");
        } else if (count % 2 == 1 && count > 0) {
            System.out.println("Alice");
        }
    }
}

