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
        if(head==null || head.next==null || k==0)
            return head;
        
        //compute length
        int len = 1;
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        
        //making the last node point to the start of the linked list
        temp.next = head;
        
        k = k%len;
        k=len-k;
        while(k-- >0) temp = temp.next;
        
        //make the node head and break the connection
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}