package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solutionj27 {
    public TreeNode mirrorTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null)return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
