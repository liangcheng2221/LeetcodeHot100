package hot100.tree;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-14 10:12
 */
public class _124_二叉树的最大路径和 {
    private int max = Integer.MIN_VALUE;

    // region 妥协版

//    /**
//     * todo 已经妥协了，真的有点抽象
//     *
//     * @param root
//     * @return
//     */
//    public int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        maxSum(root);
//        return Math.max(max, root.val);
//    }
//
//    private int maxSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = maxSum(root.left);
//        int right = maxSum(root.right);
//        int max = Math.max(left + root.val, right + root.val);
//        this.max = Math.max(max, this.max);
//        return max;
//    }

    // endregion

    // region 第二次尝试版,逻辑还是混乱了


//    public int maxPathSum(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        maxSum(root);
//        maxPathSum(root.left);
//        maxPathSum(root.right);
//        return max;
//    }
//
//    private int maxSum(TreeNode root) {
//
//
//        if (root == null){
//            return 0;
//        }
//        int left = maxSum(root.left) + root.val;
//        int right = maxSum(root.right) + root.val;
//        max = Math.max(left,right);
//        return Math.max(left,right);
//    }

    // endregion

    // region 题解版


    public int maxPathSum(TreeNode root) {

        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null){
            return 0;
        }

        // 只有左右节点都大于零时，才取左右节点的最优数值
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        int priceMax = root.val + left + right;

        max = Math.max(priceMax,max);

        return root.val + Math.max(left,right);

    }


    // endregion

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
