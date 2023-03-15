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
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.left = null;
        root.right = leftNode;
        while (root.right != null){
            root = root.right;
        }
        root.right = rightNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
