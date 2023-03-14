package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        visit(root,ans);
        return ans;
    }

    private void visit(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        ans.add(root.val);
        visit(root.left, ans);
        visit(root.right, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
