package personal.practices.job.neteasy;

import java.util.Scanner;

/**
 * Created by Stubborn on 2017/9/9.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        scanner.close();
        if (line.charAt(line.length() - 2) == ')') {
            System.out.println(line.length() / 2 - 1);
        } else {
            System.out.println(3);
        }
    }
}
