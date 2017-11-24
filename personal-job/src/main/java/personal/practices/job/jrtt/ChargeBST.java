package personal.practices.job.jrtt;

import java.util.Stack;

/**
 * 要求：
 * 判断一颗二叉树是否为二叉搜索树
 * <p>
 * 解决：
 * 中序遍历二叉搜索树，结果有序
 * Created by Stubborn on 2017/10/27.
 */
public class ChargeBST {

    public Stack<Integer> stack = new Stack();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        midThrough(root);
        int i = stack.pop();
        while (!stack.isEmpty()) {
            int j = stack.pop();
            if (i <= j) {
                return false;
            }
            i = j;
        }
        return true;
    }

    public void midThrough(TreeNode root) {
        if (root != null) {
            midThrough(root.left);
            stack.push(root.value);
            midThrough(root.right);
        }
    }

    class TreeNode {

        int value;

        TreeNode left;

        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
