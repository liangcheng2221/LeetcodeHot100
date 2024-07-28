package hot100.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-17 8:06
 */
public class _106_从后序和中序遍历序列构造二叉树 {

    private final Map<Integer,Integer> indexMap = new HashMap<>();

    /**
     * 和前序、中序的拼接是类似的（只要找出前序/后序的开始和结束节点就可以了）
     * 中序的很好确定（前提是需要map存储）
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }

        return buildTree(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postLeft, int postRight, int inorderLeft, int inorderRight) {

        if (postLeft > postRight || inorderLeft > inorderRight) {
            return null;
        }

        // 根节点的值
        int rootVal = postorder[postRight];

        // 找出根节点
        TreeNode root = new TreeNode(rootVal);

        // 根节点在中序序列的索引
        int rootIndex = indexMap.get(rootVal);

        // 右节点的个数
        int rightNumber = inorderRight - rootIndex;

        root.left = buildTree(inorder,postorder,postLeft,postRight - rightNumber -1,inorderLeft,rootIndex - 1);
        root.right = buildTree(inorder,postorder,postRight - rightNumber,postRight -1,rootIndex + 1,inorderRight);


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
