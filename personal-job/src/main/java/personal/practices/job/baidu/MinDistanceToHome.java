package personal.practices.job.baidu;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。
 * 现在他需要依次的从0号坐标走到N-1号坐标。但是除了0号坐标和N-1号坐标，
 * 他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，
 * 问度度熊回家至少走多少距离？
 * <p>
 * 解题思路:
 * 依次计算前后两个点之间的距离，找到两个距离之和最大的值，这样便找到了导致距离会变得最大的坐标，删除该坐标即可
 * </p>
 * Created by Stubborn on 2017/9/19.
 */
public class MinDistanceToHome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] originArray = new int[n];
        for (int i = 0; i < n; i++) {
            originArray[i] = scanner.nextInt();
        }
        scanner.close();
        int removedIndex = process(originArray);
        for (int i = removedIndex; i < n - 1; i++) {
            originArray[i] = originArray[i + 1];
        }
        originArray = Arrays.copyOf(originArray, originArray.length - 1);
        int sum = 0;
        for (int i = 0; i < originArray.length - 1; i++) {
            sum += Math.abs(originArray[i + 1] - originArray[i]);
        }
        System.out.println(sum);
    }


    private static int process(int[] originArray) {
        int[] gapArray = new int[originArray.length - 1];
        for (int i = 0; i < originArray.length - 1; i++) {
            int gap = Math.abs(originArray[i + 1] - originArray[i]);
            gapArray[i] = gap;
        }
        int maxDistanceCanBeRemoved = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < gapArray.length - 1; i++) {
            if (gapArray[i] + gapArray[i + 1] > maxDistanceCanBeRemoved) {
                maxDistanceCanBeRemoved = gapArray[i] + gapArray[i + 1];
                index = i;
            }
        }
        return index + 1;
    }
}
