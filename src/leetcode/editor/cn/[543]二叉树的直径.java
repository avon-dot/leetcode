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
class Solution543 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        maxLen(root);
        return ans - 1;
    }

    private int maxLen(TreeNode root) {
        if (root == null){
            return 0;
        }
// 计算出左子树的深度和右子树的深度
        int maxL = maxLen(root.left);
        int maxR = maxLen(root.right);
//        那么经过该节点的最长的节点数就是左+右+1，有可能是最长的一条路径
//        计算经过每一个节点的最长路径，取这个路径中的最大值
        ans = Math.max(ans, maxL + maxR + 1);
//        返回当前节点的最大深度
        return Math.max(maxL,maxR) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
