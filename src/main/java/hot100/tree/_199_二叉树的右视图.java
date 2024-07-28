package hot100.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-11 10:43
 */
public class _199_二叉树的右视图 {

    // region 自己的解法（没做对）

//    /**
//     * 有深度优先和广度优先的解法
//     * 广度优先很好理解
//     * todo 深度优先不知道是个什么解法
//     *
//     * @param root
//     * @return
//     */
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> right = new ArrayList<>();
//        List<Integer> left = new ArrayList<>();
//        rigit(root, right);
//        rigit(root, left);
//        return right;
//    }
//
//    private void rigit(TreeNode root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        if (root.right == null) {
//            rigit(root.left, list);
//        } else {
//            rigit(root.right, list);
//        }
//
//    }
//
    // endregion

    // region 广度优先做法

//    /**
//     * 广度优先的做法还是比较好理解
//     *
//     * @param root
//     * @return
//     */
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        dfs(root, list);
//        return list;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list) {
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        int size = 1;
//        deque.addLast(root);
//        while (!deque.isEmpty()) {
//            for (int i = 0; i < size; i++) {
//                TreeNode treeNode = deque.removeFirst();
//                if (treeNode.left != null) {
//                    deque.addLast(treeNode.left);
//                }
//                if (treeNode.right != null) {
//                    deque.addLast(treeNode.right);
//                }
//            }
//            size = deque.size();
//            if (!deque.isEmpty()) {
//                list.add(deque.getLast().val);
//            }
//        }
//    }

    // endregion

    // region 深度优先的做法

    /**
     * 深度优先的做法还是比较好理解
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        list.add(root.val);
        int size = 1;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
            size = deque.size();
            if (!deque.isEmpty()) {
                list.add(deque.getLast().val);
            }
        }
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
