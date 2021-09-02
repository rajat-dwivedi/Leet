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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //the space and time complexity of this solution is O(l1+l2)
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ListNode temp = new ListNode(l1.val);
                l1 = l1.next;
                res.next = temp;
                res = temp;
            }else{
                ListNode temp = new ListNode(l2.val);
                l2 = l2.next;
                res.next = temp;
                res = temp;
            }
        }
        
        while(l1!=null){
            ListNode temp = new ListNode(l1.val);
            res.next = temp;
            res = temp;
            l1 = l1.next;
        }
        
        while(l2!=null){
            ListNode temp = new ListNode(l2.val);
            res.next = temp;
            res = temp;
            l2 = l2.next;
        }
        dummy = dummy.next;
    return dummy;
    }
    
}