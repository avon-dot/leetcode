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
class Solution1038 {
    private int preVal = 0;

    public TreeNode bstToGst(TreeNode root) {
        sumRightChildre(root);

        return root;
    }

    private void sumRightChildre(TreeNode root) {
        if (root == null) return;

        sumRightChildre(root.right);
        root.val += preVal;
//        System.out.println(root.val);
        preVal = root.val;
        sumRightChildre(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
