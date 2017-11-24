package personal.practices.job.microsoft;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Stubborn on 2017/9/29.
 */
public class CutMinTree {

    public static void main(String[] args) throws InterruptedException {
        CutMinTree cutMinTree = new CutMinTree();
        int[][] grid = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}};
        System.out.println(cutMinTree.process(5, 4, 2, grid));
    }

    public int process(int rows, int columns, int numTreeGroup, int[][] grid) throws InterruptedException {
        boolean[][] visited = new boolean[rows][columns];
        List<List<Tree>> treeGroupList = new ArrayList<>();
        List<Tree> treeList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    Tree tree = new Tree(i, j);
                    treeList.add(tree);
                }
            }
        }
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);

            if (!visited[tree.getIndex_r()][tree.getIndex_c()]) {
                visited[tree.getIndex_r()][tree.getIndex_c()] = true;
                List<Tree> treeGroup = new ArrayList<>();
                Queue<Tree> fj = new LinkedList<>();
                fj.poll();
                BlockingQueue<Tree> treeQueue = new LinkedBlockingQueue<>();
                treeQueue.add(tree);
                while (!treeQueue.isEmpty()) {
                    Tree tmpTree = treeQueue.take();
                    treeGroup.add(tmpTree);
                    List<Tree> adjacentTrees = getAdjacentTree(tmpTree, rows, columns, grid);
                    for (Tree tree1 : adjacentTrees) {
                        if (!visited[tree1.getIndex_r()][tree1.getIndex_c()]) {
                            visited[tree1.getIndex_r()][tree1.getIndex_c()] = true;
                            treeQueue.add(tree1);
                        }
                    }
                }
                treeGroupList.add(treeGroup);
            }
        }
        Collections.sort(treeGroupList, new Comparator<List<Tree>>() {
            @Override
            public int compare(List<Tree> o1, List<Tree> o2) {
                return o2.size() - o1.size();
            }
        });
        int minSum = 0;
        for (int i = numTreeGroup; i < treeGroupList.size(); i++) {
            minSum += treeGroupList.get(i).size();
        }
        return minSum;
    }

    public List<Tree> getAdjacentTree(Tree tree, int row, int column, int[][] grid) {
        List<Tree> adjacentTrees = new ArrayList<>();
        int index_r = tree.getIndex_r();
        int index_c = tree.getIndex_c();
        if (index_r - 1 >= 0 && grid[index_r - 1][index_c] == 0) {
            adjacentTrees.add(new Tree(index_r - 1, index_c));
        }
        if (index_c - 1 >= 0 && grid[index_r][index_c - 1] == 0) {
            adjacentTrees.add(new Tree(index_r, index_c - 1));
        }
        if (index_r + 1 < row && grid[index_r + 1][index_c] == 0) {
            adjacentTrees.add(new Tree(index_r + 1, index_c));
        }
        if (index_c + 1 < column && grid[index_r][index_c + 1] == 0) {
            adjacentTrees.add(new Tree(index_r, index_c + 1));
        }
        return adjacentTrees;
    }


}

class Tree {

    int index_r;

    int index_c;

    public Tree(int index_r, int index_c) {
        this.index_r = index_r;
        this.index_c = index_c;
    }

    public int getIndex_r() {
        return index_r;
    }

    public int getIndex_c() {
        return index_c;
    }
}
