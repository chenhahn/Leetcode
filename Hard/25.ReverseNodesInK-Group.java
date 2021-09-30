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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        Stack<ListNode> stk = new Stack<ListNode>();
        int count = k;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = head, next = head;
        while(temp != null || count == 0){
            if(count != 0){
                stk.push(temp);
                count--;
                temp = temp.next;
            }else{
                next = temp;
                while(!stk.empty()){
                    current.next = stk.pop();
                    current = current.next;  
                }
                count = k;
            }
        }
        current.next = next;
        return dummy.next;
    }
}