package personal.practices.job.huawei;

import java.util.Scanner;

/**
 * 数据压缩
 * 输入：abbbb
 * 输出：a4b
 * Created by CBStubborn on 2017/11/13.
 */
public class Compress {

    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        String result = compress(line);
        System.out.println(result);
    }

    public static String compress(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char tmpCh = str.charAt(i);
            if (tmpCh == ch) {
                count++;
            } else {
                if (count == 1) {
                    stringBuilder.append(String.valueOf(ch));
                } else {
                    stringBuilder.append(count + String.valueOf(ch));
                }
                ch = tmpCh;
                count = 1;
            }
        }
        stringBuilder.append(count + String.valueOf(ch));
        return stringBuilder.toString();
    }
}
