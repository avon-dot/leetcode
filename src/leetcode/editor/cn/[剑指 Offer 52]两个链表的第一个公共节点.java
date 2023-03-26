package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null ||  headB == null){
            return null;
        }

        ListNode rootA = headA;
        ListNode rootB = headB;

        while (rootA != rootB){
            rootA = rootA == null ? headB : rootA.next;
            rootB = rootB == null ? headA : rootB.next;
        }

        return rootA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
