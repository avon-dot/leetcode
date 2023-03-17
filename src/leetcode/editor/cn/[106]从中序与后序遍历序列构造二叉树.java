package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0){
            return null;
        }
//        先找到根节点
        TreeNode root = new TreeNode(postorder[n - 1]);
//        找到左右子树分割点
        int index = 0;
        for (; index < n; index++) {
            if(inorder[index] == postorder[n - 1]){
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index + 1,n),Arrays.copyOfRange(postorder,index,n - 1));

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
