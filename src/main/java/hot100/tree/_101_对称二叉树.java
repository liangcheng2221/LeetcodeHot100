package hot100.tree;

/**
 * @author yinjie
 * @date 2024-04-08 8:41
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if ((root.left != null && root.right == null) || (root.right != null && root.left == null)) {
            return false;
        }
        if (root.left == null) {
            return true;
        }

        if (root.left.val != root.right.val) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 检查左右子树是否为镜像
        return check(left, right);

    }

    /**
     * 蠢货版
     *
     * @param left
     * @param right
     * @return
     */
    private boolean check(TreeNode left, TreeNode right) {

        // 左右子树必须存在
        if ((left != null && right == null) || (right != null && left == null)) {
            return false;
        }

        if (left == null) {
            return true;
        }

        // 左子树和右子树的镜像必须存在
        if ((left.left == null && right.right != null)
                || (left.right == null && right.left != null)
                || (left.left != null && right.right == null)
                || (left.right != null && right.left == null)) {
            return false;
        }


        // 左右子树的镜像必须相等
        if (left.left != null && left.left.val != right.right.val) {
            return false;
        }
        if (left.right != null && left.right.val != right.left.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    // region

    /**
     * 优化版
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check1(root.left, root.right);

    }

    private boolean check1(TreeNode left, TreeNode right) {
        // 左右子树必须存在
        if ((left != null && right == null) || (right != null && left == null)) {
            return false;
        }

        if (left == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }

        return check1(left.left, right.right) && check1(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
