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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int numOfNodes = 1;
        while(current.next != null){
           current = current.next;
            numOfNodes++;
        } 
        int indexOfRemove = numOfNodes - n;
        
        if(indexOfRemove == 0){
            head = head.next;
            return head;
        }
        
        current = head;
        for(int i = 1; i < indexOfRemove; i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}