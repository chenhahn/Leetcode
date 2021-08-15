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
    public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
        ListNode node;
        int l1Value = (l1 != null? l1.val : 0);
        int l2Value = (l2 != null? l2.val : 0);
        int sum = l1Value + l2Value + carry;
        
        if(sum == 0 && l1 == null && l2 == null) return null;
        
        node = new ListNode(sum%10);
        
        if(l1 != null || l2 != null){
            node.next = addTwoNumbersWithCarry(l1 != null? l1.next : null, 
			l2 != null? l2.next : null, 
			sum / 10);
        }
        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        return addTwoNumbersWithCarry(l1, l2, 0);
    }
}