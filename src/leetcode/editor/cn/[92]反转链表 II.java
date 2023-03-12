package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null || left == right){
            return head;
        }

        int index = 1;
        ListNode leftNode = head;
        ListNode leftPreNode = null;
        while (leftNode != null && index < left){
            index++;
            leftPreNode = leftNode;
            leftNode = leftNode.next;

        }
        ListNode curr = leftNode;
        ListNode pre = null;
        while (curr != null && index <= right){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

            index++;
        }

        if (leftPreNode == null){
            head = pre;
        }else {
            leftPreNode.next = pre;
        }

        leftNode.next = curr;

        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
