package personal.practices.job.leetcode;


import java.util.*;

/**
 * 要求：
 * 给定一个字符串，求该字符串的一个最长子串，使得子串中不包含重复字符
 * 本解决方案已通过测验.
 * Created by Stubborn on 2017/9/20.
 */
public class LongestSubStringWithoutRepeatingCharacters {

    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abcdajkliopuyr";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(process(str));
        System.out.println("不重复最大子串为: " + list.toString());
    }

    /**
     * 获取不重复最大子串长度
     *
     * @param originString
     * @return
     */
    private static int process(String originString) {
        int maxLength = Integer.MIN_VALUE;
        int tmpLength = 0;
        for (int i = 0; i < originString.length(); i++) {
            char ch = originString.charAt(i);
            if (!list.contains(ch)) {
                tmpLength++;
                list.add(ch);
            } else {
                if (tmpLength > maxLength) {
                    maxLength = tmpLength;
                }
                for (int j = 0; j < list.size(); ) {
                    char tmpCh = list.get(j);
                    if (tmpCh != ch) {
                        list.remove(j);
                    } else {
                        list.remove(j);
                        break;
                    }
                }
                list.add(ch);
                tmpLength = list.size();
            }
        }
        return maxLength > list.size() ? maxLength : list.size();
    }

    /**
     * 此方法更简单
     *
     * @param originString
     * @return
     */
    public static int lengthOfLongestSubstring(String originString) {
        if (originString.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < originString.length(); i++) {
            if (map.containsKey(originString.charAt(i))) {
                j = Math.max(j, map.get(originString.charAt(i)) + 1);
            }
            map.put(originString.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
