package personal.practices.job.zaxiang;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串x，求包含字符串y中所有字符的最小的x子串。
 * 注意：
 * 1. 只需包含y中所有字符即可，不要求按照y中顺序，如果有顺序要求，参考“xiaomi”包中的解决方案。
 * 2. y中每个字符可能出现多次，如果出现多次，使用方法process，如果仅出现一次，使用方法_process
 * 3. 如果y中每个字符仅出现一次，那么对应出现另一种题型：
 * 给定字符串x，求包含该字符串中所有字符的最小子串。（把_process方法中的参数target改为x中的所有字符组成的串即可）
 * Created by Stubborn on 2017/9/19.
 */
public class MinSubArrayCoverAllCharacter {

    static Map<Character, Integer> needToFindMap = new HashMap<>();

    static Map<Character, Integer> hasFoundMap = new HashMap<>();

    /**
     * 可重复
     * 参考链接：http://blog.csdn.net/sunnyyoona/article/details/43924715?spm=5176.100239.blogcont3558.3.9gAvqt
     *
     * @param source
     * @param target
     * @return
     */
    private static String process(String source, String target) {
        int sLength = source.length();
        int tLength = target.length();
        if (sLength <= 0 || tLength <= 0 || sLength < tLength) {
            return null;
        }
        for (char ch : target.toCharArray()) {
            if (source.indexOf(ch) == -1) {
                return null;
            }
            Integer count = needToFindMap.get(ch);
            if (count == null) {
                count = 0;
            }
            count++;
            needToFindMap.put(ch, count);
        }
        int hasFoundCount = 0;
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int startIndex = 0, endIndex = 0; endIndex < source.length(); endIndex++) {
            char ch = source.charAt(endIndex);
            if (needToFindMap.get(ch) == null) {
                continue;
            }
            Integer count = hasFoundMap.get(ch);
            if (count == null) {
                count = 0;
            }
            count++;
            hasFoundMap.put(ch, count);
            if (count <= needToFindMap.get(ch)) {
                hasFoundCount++;
            }
            if (hasFoundCount == target.length()) {
                char startCh = source.charAt(startIndex);
                while (needToFindMap.get(startCh) == null || hasFoundMap.get(startCh) > needToFindMap.get(startCh)) {
                    if (needToFindMap.get(startCh) != null && hasFoundMap.get(startCh) > needToFindMap.get(startCh)) {
                        Integer tmpCount = hasFoundMap.get(startCh);
                        tmpCount--;
                        hasFoundMap.put(startCh, tmpCount);
                    }
                    startIndex++;
                    startCh = source.charAt(startIndex);
                }
                int currentWindow = endIndex - startIndex + 1;
                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    start = startIndex;
                    end = endIndex;
                }
            }

        }
        return source.substring(start, end + 1);
    }

    /**
     * 不可重复
     * 参考链接：http://blog.csdn.net/sunnyyoona/article/details/43925577
     *
     * @param source
     * @param target
     * @return
     */
    private static String _process(String source, String target) {
        int sLength = source.length();
        int tLength = target.length();
        if (sLength <= 0 || target.length() <= 0 || sLength < tLength) {
            return null;
        }
        for (char ch : target.toCharArray()) {
            if (source.indexOf(ch) == -1) {
                return null;
            }
        }
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int startIndex = 0, endIndex = 0; endIndex < source.length(); endIndex++) {
            char ch = source.charAt(endIndex);
            if (target.indexOf(ch) == -1) {
                continue;
            }
            Integer count = hasFoundMap.get(ch);
            if (count == null) {
                count = 0;
            }
            count++;
            hasFoundMap.put(ch, count);
            if (hasFoundMap.size() == target.length()) {
                char startCh = source.charAt(startIndex);
                while (hasFoundMap.get(startCh) == null || hasFoundMap.get(startCh) > 1) {
                    Integer tmpCount = hasFoundMap.get(startCh);
                    if (tmpCount != null) {
                        tmpCount--;
                        hasFoundMap.put(startCh, tmpCount);
                    }
                    startIndex++;
                    startCh = source.charAt(startIndex);
                }
                int currentWindow = endIndex - startIndex + 1;
                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    start = startIndex;
                    end = endIndex;
                }
            }
        }
        return source.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String result = _process("acbbacad", "bd");
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("未找到");
        }
    }
}
