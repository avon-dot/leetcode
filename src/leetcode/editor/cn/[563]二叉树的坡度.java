package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
class Solution563 {
//    添加每一个节点的坡度
    private int ans = 0;

    public int findTilt(TreeNode root) {
        if (root == null)return 0;
        sumNode(root);
        return ans;
    }

    private int sumNode(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumNode(root.left);
        int rightSum = sumNode(root.right);

//        记录当前节点的坡度
        ans += Math.abs(leftSum - rightSum);
//        后序操作，记录当前子树的总和
        return leftSum + rightSum + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
