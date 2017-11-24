package personal.practices.job.shunfeng;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/20.
 */
public class Password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < n - 1; i++) {
            System.out.println(A[i] + A[i + 1]);
        }

        System.out.println(A[n - 1]);
    }

}
