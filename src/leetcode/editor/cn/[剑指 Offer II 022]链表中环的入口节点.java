package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution022 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode fast = head, slow = head;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            } else {
                return null;
            }

            if (slow == fast){
                ListNode ans = head;
                while (ans != slow){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
