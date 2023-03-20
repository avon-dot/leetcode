package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
class Solution652 {
    Map<String,Integer> treeNum = new HashMap<String,Integer>();
    LinkedList<TreeNode> ans = new LinkedList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return ans;
    }

    private String traverse(TreeNode root) {
        if (root == null){
            return "#";
        }

        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);

        String subTree = leftStr + "," + rightStr + "," + root.val;

        int freq = treeNum.getOrDefault(subTree,0);
        if (freq == 1){
            ans.add(root);
        }

        treeNum.put(subTree, freq + 1);

        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
