package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
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
class Solution889 {
    private Map<Integer,Integer> idm = new HashMap<Integer,Integer>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 1){
            return new TreeNode(preorder[0]);
        }

//        方便寻找元素
        for (int i = 0; i < postorder.length; i++) {
          idm.put(postorder[i],i);
        }

//        构建index位置为root的树
        TreeNode root = buildTree(0, 0, preorder.length, preorder,postorder);

        return root;
    }

    private TreeNode buildTree(int left, int right, int n,int[] preorder, int[] postorder) {
//        节点数为0的时候，就是返回null
        if (n == 0) return null;
//        根节点是index
        TreeNode root = new TreeNode(preorder[left]);
        if (n == 1) return root;

//        找到左右子树的分界点
        int index = idm.get(preorder[left + 1]);
//        找到左子树的节点数目
        int leftChildrenNum = index - right + 1;
//        找到右子树的节点数目
        int rightChildrenNum = n - 1 - leftChildrenNum;

//        生产左子树
        root.left = buildTree(left + 1, right, leftChildrenNum,preorder, postorder);
//        生成右子树
        root.right = buildTree(left + leftChildrenNum + 1,index + 1,rightChildrenNum, preorder,postorder);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
