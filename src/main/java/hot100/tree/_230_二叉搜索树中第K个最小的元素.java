package hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-04-11 10:15
 */
public class _230_二叉搜索树中第K个最小的元素 {

    /**
     * 直接中序遍历秒了
     * todo 原题有一个进阶的，后面看能不能进行实现
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        mid(root, list);
        System.out.println(list);
        return list.get(list.size() - k);
    }

    private void mid(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        mid(root.left, list);
        list.add(root.val);
        mid(root.right, list);
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
