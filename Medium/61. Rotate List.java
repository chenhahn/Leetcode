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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) 
            return null;
            
        int length = 1;
        ListNode end = head;
        ListNode current = head;
        ListNode prev = null;
        
        while (end.next != null) {
            end = end.next;
            length++;
        }
        int n = k % length;
        
        if (n == 0)
            return head;
        
        n = length - n;
        
        while (n > 0 && current.next != null) {
            prev = current;
            current = current.next;
            n--;
        }
        
        prev.next = null;
        end.next = head;
        return current;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)