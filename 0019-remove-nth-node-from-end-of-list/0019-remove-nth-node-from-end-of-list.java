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
        int cnt =0;
        ListNode temp = head;
        // count total number of nodes
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        // if head needs to remove
        if(cnt == n){
            return head.next;
        }
        // reach the node before the target
        temp = head;
        int pos = 1;
        while(pos < cnt-n){
            temp = temp.next;
            pos++;
            }
            //delete the target node
            temp.next = temp.next.next;
            return head;
        
        
    }
}