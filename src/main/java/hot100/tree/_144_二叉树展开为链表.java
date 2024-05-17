package hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @date 2024-04-11 11:06
 */
public class _144_二叉树展开为链表 {
//    public static void flatten(TreeNode root) {
//        TreeNode right = new TreeNode();
////        TreeNode test = right;
//        front(root, right);
//        System.out.println(right);
////        System.out.println(right.right.val);
////        root = right;
//    }
//
//    private static void front(TreeNode root, TreeNode right) {
//        if (root == null) {
//            return;
//        }
//
//        right.right = new TreeNode(root.val);
//        front(root.left,right.right);
//        front(root.right,right.right);
//
//    }
//
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(2);
//        treeNode.right = new TreeNode(4);
//        treeNode.left = new TreeNode(1);
//        flatten(treeNode);
//    }

    /**
     * todo 这里比较抽象，好像有一个非常重要的知识有点没搞懂（值传递，引用传递）
     *      高级的做法有直接找前驱节点
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        front(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode treeNode = list.get(i);
            pre.right = treeNode;
            pre.left = null;
        }

    }

    private void front(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        front(root.left, list);
        front(root.right, list);
    }


    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
