package personal.practices.job.xiaomi;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 要求：
 * 求任意整数的阶乘
 * Created by Stubborn on 2017/9/18.
 */
public class JieCheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        List<String> inputLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();
        for (String line : inputLines) {
            process(line);
        }
    }

    private static void process(String line) {
        BigInteger bigNumber = new BigInteger(line);
        BigInteger answer = new BigInteger("1");
        for (BigInteger i = BigInteger.ONE; i.compareTo(bigNumber) <= 0; i = i.add(BigInteger.ONE)) {
            answer = answer.multiply(i);
        }
        System.out.println(answer);
    }

}
