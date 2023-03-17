package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

//        交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

//        交换左子节点
        traverse(root.left);
//        交换右子节点
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
