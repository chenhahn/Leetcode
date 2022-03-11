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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode current = dummyNode;
        while (current.next != null) {
            current = current.next;
            if (current.val == val) {
                preNode.next = current.next;
            } else {
                preNode = preNode.next;
            }
        }
        return dummyNode.next;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)