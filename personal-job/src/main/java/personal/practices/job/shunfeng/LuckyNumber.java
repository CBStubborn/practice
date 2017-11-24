package personal.practices.job.shunfeng;

import java.math.BigInteger;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by Stubborn on 2017/9/20.
 */
public class LuckyNumber {

    public static void main(String[] args) {
        BigInteger bigInteger = process(758);
        System.out.println(bigInteger);
    }

    private static BigInteger process(int inputNumber) {
        String numberToString = String.valueOf(inputNumber);
        int length = numberToString.length();
        BigInteger bigInteger = calculate(length);
        for (int i = 0; i < numberToString.length(); i++) {
            int value = Integer.valueOf(String.valueOf(numberToString.charAt(i)));
            if (value < 4) {
                break;
            } else if (value == 4) {
                continue;
            } else if (value > 4 && value < 7) {
                bigInteger = bigInteger.add(calculate(length - i - 1));
                break;
            } else if (value == 7) {
                bigInteger = bigInteger.add(calculate(length - i - 1));
                continue;
            } else {
                bigInteger = bigInteger.add(calculate(length));
                break;
            }
        }
        return bigInteger;
    }


    private static BigInteger calculate(int length) {
        return new BigInteger(String.valueOf((long) Math.pow(2, length) - 2));
    }
}