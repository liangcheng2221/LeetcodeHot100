package hot100.tree;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-08 9:23
 */
public class _543_二叉树的直径 {
    public int ans;


    /**
     * // todo 实现了单个节点的左右边之和
     * 做不出版
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeSimple(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return height(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return height(root.left) + 1;
        }

        return height(root.left) + height(root.right) + 2;

    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * 有点巧妙，好像和我昨天看的回溯过程一样：递归结束条件，选择，返回值
     *
     * @param root 根节点
     * @return 返回二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;

        ans = Math.max(ans, left + right);

        return Math.max(left, right);
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
