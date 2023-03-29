package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;
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
class Solution1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> listA = new ArrayList<Integer>();
        traverse(root1, listA);
        List<Integer> listB = new ArrayList<Integer>();
        traverse(root2, listB);

        List<Integer> ans = new ArrayList<Integer>();
        int indexA = 0;
        int indexB = 0;

        while (true){
            if (indexA == listA.size()){
                ans.addAll(listB.subList(indexB,listB.size()));
                break;
            }

            if (indexB == listB.size()){
                ans.addAll(listA.subList(indexA,listA.size()));
                break;
            }

            if (listB.get(indexB) < listA.get(indexA)){
                ans.add(listB.get(indexB));
                indexB++;
            }else {
                ans.add(listA.get(indexA));
                indexA++;
            }
        }

        return ans;
    }

    private void traverse(TreeNode root,List<Integer> list) {
        if (root == null){
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
