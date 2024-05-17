package hot100.tree;

import java.util.*;

/**
 * @author yinjie
 * @date 2024-04-09 9:23
 */
public class _102_二叉树的层序遍历 {
    /**
     * 思路很巧妙：首先写出层序遍历的操作，每次进行出队和入队完，记录
     * 队列的大小，此时的队列的大小就是每一层的元素个数
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
//        Map<Integer,>
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 每次遍历完就记录队列的大小
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
//                System.out.println(treeNode.val);
            }
            result.add(level);
        }
        return result;
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
