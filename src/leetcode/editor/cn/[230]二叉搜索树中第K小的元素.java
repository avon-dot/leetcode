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
class Solution230 {
    private int ans = 0;
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        ans = root.val;
        traverse(root,k);
        return ans;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        index++;
        if (index == k){
            ans = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
