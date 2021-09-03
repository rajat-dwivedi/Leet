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
    //tc - O(N/2)+O(N/2)+O(N/2) sc - O(1)
    
    //function to reverse a linked list
    ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second half of the list
        slow.next = reverse(slow.next);
        //move slow to point to first element in the second half
        slow = slow.next;
        
        //take one pointer to the first element and move along the second half of the list
        while(slow!=null){
            if(start.val!=slow.val)
                return false;
            slow = slow.next;
            start = start.next;
        }
        
        return true;
    }
}