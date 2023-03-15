package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

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
class FindElements {
//    存放数据
    Set<Integer> elements = new HashSet<Integer>();
    public FindElements(TreeNode root) {
        int x = 0;
//        先序遍历赋值
        setElement(root,x);
    }

    private void setElement(TreeNode root, int x) {
        if (root == null) return;
        root.val = x;
        elements.add(x);
        setElement(root.left,2 * x + 1);
        setElement(root.right, 2 * x + 2);
    }


    public boolean find(int target) {
        return elements.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
