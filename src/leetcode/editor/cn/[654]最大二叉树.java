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
class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int left = 0, right = nums.length - 1;
        return buildTree(left, right, nums);
    }

    private TreeNode buildTree(int left, int right, int[] nums) {
        if (left > right) return null;

        int max = Integer.MIN_VALUE;
        int id = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                id = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = buildTree(left,id - 1,nums);
        root.right = buildTree(id + 1, right, nums);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
