package personal.practices.job.baidu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 要求：
 * 主人临时需要处理紧急事务，取消宴会，现在需要通知他的邻居，尽量使得最多的人知道
 * 输入：
 * 一个字符串，每个字符代表一个邻居，其中c表示乐于助人的邻居，他收到宴会取消的消息后，会告诉他左边两个邻居及右边两个邻居
 * n表示消极邻居，他收到宴会取消的消息后，不会告诉任何人。
 * 输出：
 * 当某个人知道宴会取消的消息后，将其对应的字符改为I,没收到消息的人，其字符为U.
 * 当存在多种情况使得知道消息的人数最多时，则选择使得输出字符串最小的情况，例如
 * IIIIUUUUU 和 UIIIIUUUU,知道消息的人数都为4，选择输出前者
 * </p>
 * Created by Stubborn on 2017/9/19.
 */
public class CancelParty {

    public static void main(String[] args) {
        String result = process("cnncncccnnccncncncnn");
        System.out.println(result);
    }

    private static String process(String originStr) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        List<Point> points = new ArrayList<>();
        char[] chars = originStr.toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Point point = new Point(ch, i);
            if ("n".equals(String.valueOf(ch))) {
                if (count > 0) {
                    count--;
                    continue;
                } else {
                    stringBuilder.append(ch);
                    points.add(point);
                }
            } else {
                count = 1;
                stringBuilder.append(ch);
                points.add(point);
            }
        }
        if (points.size() == chars.length - 1) {
            result.append("I");
            for (int i = 1; i < chars.length; i++) {
                result.append("U");
            }
            return result.toString();
        }
        String str = stringBuilder.toString();
        System.out.println(str);
        int maxLength = 0;
        int tmpLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tmpStartIndex = 0;
        int tmpEndIndex;
        for (int i = 0; i < str.length(); i++) {
            if ("c".equals(String.valueOf(str.charAt(i)))) {
                if (tmpLength == 0) {
                    tmpStartIndex = i;
                }
                tmpLength++;
            } else if ("n".equals(String.valueOf(str.charAt(i)))) {
                tmpEndIndex = i - 1;
                if (tmpLength > maxLength) {
                    maxLength = tmpLength;
                    startIndex = tmpStartIndex;
                    endIndex = tmpEndIndex;
                }
                tmpLength = 0;
            }
        }
        if (tmpLength > maxLength) {
            startIndex = tmpStartIndex;
            endIndex = chars.length - 1;
        }
        Point callPoint = points.get(startIndex);
        Point stopPoint = points.get(endIndex);
        int callIndex = callPoint.getIndex();
        int stopIndex = stopPoint.getIndex();
        for (int i = 0; i < callIndex - 2; i++) {
            result.append("U");
        }
        int i;
        if (callIndex < 2) {
            i = 0;
        } else {
            i = callIndex - 2;
        }
        for (; i < stopIndex + 3 && i < chars.length; i++) {
            result.append("I");
        }
        for (int j = stopIndex + 3; j < chars.length; j++) {
            result.append("U");
        }
        return result.toString();
    }

    static class Point {

        char ch;

        int index;

        public Point(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
