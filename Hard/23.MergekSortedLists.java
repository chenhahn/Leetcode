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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                index = i;
            }
        }
        if(index != -1){
            ListNode result = lists[index];
            lists[index] = lists[index].next;
            result.next = mergeKLists(lists);
            return result; 
        }else{
            return null;
        }
        
    }
}

//PriorityQueue


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null) pq.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return head.next;     
    }
}