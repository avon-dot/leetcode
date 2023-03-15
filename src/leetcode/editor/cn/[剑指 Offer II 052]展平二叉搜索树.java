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
class Solution052 {
    private TreeNode resNode = null;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode; // 引入一个节点，然后遍历过程中改变当前的节点的指针指向
        bst(root);
        return dummyNode.right;
    }

    private void bst(TreeNode root) {
        if (root == null)return;
        bst(root.left);

//        中序操作
        resNode.right = root;
        root.left = null;
        resNode = root;

        bst(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
