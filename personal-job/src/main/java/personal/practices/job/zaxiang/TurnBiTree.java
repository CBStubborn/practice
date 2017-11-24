package personal.practices.job.zaxiang;

/**
 * Created by CBStubborn on 2017/11/20.
 * 二叉树翻转实现
 */
public class TurnBiTree {

    public void turn(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.getLeft();
        turn(left);
        TreeNode right = root.getRight();
        turn(right);
        TreeNode tmpNode = left;
        left = right;
        right = tmpNode;
    }


    class TreeNode {

        int value;

        TreeNode left;

        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left) {
            this.value = value;
            this.left = left;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
