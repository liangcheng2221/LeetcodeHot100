package hot100.tree;

import java.util.Map;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-13 9:47
 */
public class _437_路径总和3 {
    /**
     * 盲猜一手就是用的深度优先算法
     * todo 看着题解写出来的，有点小抽象
     *      不过有一说一时间复杂度是真的高，先是要递归每个节点，然后每个节点都要递归。（相当于双重递归）
     *      题解有一个前缀和的算法，还不知道是怎么回事。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null){
            return 0;
        }

        int ret = sum(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);
        return ret;
    }

    private int sum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null){
            return 0;
        }
        int val = root.val;

        if (val == targetSum){
            ret++;
        }

        ret += sum(root.left,targetSum - val);
        ret += sum(root.right,targetSum - val);
        return ret;
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
