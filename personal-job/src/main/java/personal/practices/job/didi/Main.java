package personal.practices.job.didi;

import java.util.Scanner;


/**
 * Created by Stubborn on 2017/9/10.
 */
public class Main {

    public void process(int[] numbers) {
        int count = 0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int xor = numbers[i];
            if (xor == 0) {
                count++;
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if ((xor ^ numbers[j]) == 0) {
                    count++;
                    i = j;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        Main main = new Main();
        main.process(numbers);
    }
}

