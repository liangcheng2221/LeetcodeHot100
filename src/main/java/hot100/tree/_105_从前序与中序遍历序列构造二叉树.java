package hot100.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinjie
 * @date 2024-04-12 9:50
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    public static final Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 终于自己做出来了，真的有点小抽象，而且比较容易出错
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inorderLeft, int inorderRight) {
        if (preLeft > preRight || inorderLeft > inorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = indexMap.get(preorder[preLeft]);

        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + rootIndex - inorderLeft + 1, inorderLeft, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preLeft + rootIndex - inorderLeft + 1, preLeft, rootIndex + 1, inorderRight);

        return root;
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
