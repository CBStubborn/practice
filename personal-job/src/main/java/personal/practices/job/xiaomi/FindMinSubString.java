package personal.practices.job.xiaomi;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * 要求：
 * 给定一个字符串x，求x中包含字符串y的最短子串，返回该字串的开始位置及截止位置，如果不存在则返回 -1 -1
 * 注意，匹配字符串y不要求连续,但是要按照y中的顺序匹配，如果不要求考虑顺序，请参考“zaxiang”包中的解决方案
 * 例如:
 * x: abaacxbcbbbbacc
 * y: cbc
 * 返回结果为：4 7
 * x: adc
 * y: h
 * 返回结果为：-1 -1
 * <p>
 * 解决方案（未经提交测试）：
 * 先将x中不在y中的字符删除，得到字符串z，并记录所有z中所有字符在x中的相应位置
 * 然后在z中顺序匹配字符串y，找到最小窗口值
 * </p>
 * Created by Stubborn on 2017/9/18.
 */
public class FindMinSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        List<String> inputLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();
        for (String line : inputLines) {
            String[] pieces = line.split(" ");
            process(pieces[0], pieces[1]);
        }
    }

    private static void process(String source, String target) {
        char[] chars = source.toCharArray();
        List<CharAndPosition> containedChars = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (target.indexOf(chars[i]) != -1) {
                CharAndPosition charAndPosition = new CharAndPosition(chars[i], i);
                containedChars.add(charAndPosition);
                stringBuilder.append(chars[i]);
            }
        }
        String containedString = stringBuilder.toString();
        if (containedString.indexOf(target) == -1) {
            System.out.println("-1 -1");
        } else {
            int count = 0;
            int startIndex = 0;
            int endIndex = 0;
            int min = Integer.MAX_VALUE;
            while (containedString.indexOf(target, count) != -1) {
                count = containedString.indexOf(target, count);
                int tmpStart = containedChars.get(count).getPosition();
                int tmpEnd = containedChars.get(count + target.length() - 1).getPosition();
                if (tmpEnd - tmpStart < min) {
                    min = tmpEnd - tmpStart;
                    startIndex = tmpStart;
                    endIndex = tmpEnd;
                }
                count++;
            }
            System.out.println(startIndex + " " + endIndex);
        }
    }

    static class CharAndPosition {

        private char ch;

        private int position;

        public CharAndPosition(char ch, int position) {
            this.ch = ch;
            this.position = position;
        }

        public char getCh() {
            return ch;
        }

        public int getPosition() {
            return position;
        }
    }
}
