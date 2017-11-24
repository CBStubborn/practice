package personal.practices.job.jrtt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 要求，输入一个数字，数字元素为0或者1，其中1代表岛屿，0代表海洋，上下左右相连的岛屿为一个岛屿
 * 求其中共有多少个岛屿
 * Created by CBStubborn on 2017/11/6.
 */
public class IslandCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(process(array));
    }

    public static int process(int[][] array) {
        int count = 0;
        int r = array.length;
        if (r <= 0) {
            return count;
        }
        int c = array[0].length;
        Queue<Integer> adjacent = new LinkedList();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (array[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    adjacent.add(i * c + j);
                }
                while (!adjacent.isEmpty()) {
                    int index = adjacent.poll();
                    int index_r = index / c;
                    int index_c = index % c;
                    if (index_r - 1 >= 0 && array[index_r - 1][index_c] == 1 && !visited[index_r - 1][index_c]) {
                        visited[index_r - 1][index_c] = true;
                        adjacent.add((index_r - 1) * c + index_c);
                    }
                    if (index_r + 1 < r && array[index_r + 1][index_c] == 1 && !visited[index_r + 1][index_c]) {
                        visited[index_r + 1][index_c] = true;
                        adjacent.add((index_r + 1) * c + index_c);
                    }
                    if (index_c - 1 >= 0 && array[index_r][index_c - 1] == 1 && !visited[index_r][index_c - 1]) {
                        visited[index_r][index_c - 1] = true;
                        adjacent.add(index_r * c + index_c - 1);
                    }
                    if (index_c + 1 < c && array[index_r][index_c + 1] == 1 && !visited[index_r][index_c + 1]) {
                        visited[index_r][index_c + 1] = true;
                        adjacent.add(index_r * c + index_c + 1);
                    }
                }
            }
        }
        return count;
    }
}
