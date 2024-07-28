package hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-14 9:38
 */
public class _236_二叉树的最近公共祖先 {
    public static final List<TreeNode> list = new ArrayList<>();
    public int count = 0;
    public TreeNode ans;

    //region 简单超时版

//    /**
//     * todo 思路倒是没错，但是超时了
//     *
//     * @param root
//     * @param p
//     * @param q
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//        boolean flag = find(root, p, q);
//        if (flag) {
//            list.add(root);
//            lowestCommonAncestor(root.left, q, p);
//            lowestCommonAncestor(root.right, q, p);
//        } else {
//            count = 0;
//        }
//        System.out.println(list);
//        return list.get(list.size() - 1);
//    }
//
//    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return false;
//        }
//        if (root == p || root == q) {
//            count++;
//        }
//        if (count == 2) {
//            count = 0;
//            return true;
//        }
//        boolean left = find(root.left, p, q);
//        boolean right = find(root.right, p, q);
//        return left || right;
//    }

    //endregion

    //region 题解版

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if ((left && right) || (root == p || root == q) && (left || right)) {
            ans = root;
        }

        return right || left || (root == p || root == q);

    }

    //endregion

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
