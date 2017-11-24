package personal.practices.job.huawei;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by CBStubborn on 2017/11/13.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int c = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            int a = scanner.nextInt();
            int result = chargeAndGet(a, b, c);
            if (result < 0) {
                continue;
            } else {
                Integer count = map.get(result);
                if (count == null) {
                    count = 0;
                }
                count++;
                map.put(result, count);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        System.out.println(max);
        scanner.close();
    }

    public static int chargeAndGet(int a, int b, int c) {
        byte[] bytes = intToByteArray(a);
        byte sum = 0x0;
        for (byte bt : bytes) {
            sum += bt;
        }
        int left = sum % b;
        if (left < c) {
            return left;
        } else {
            return -1;
        }
    }

    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }
}
