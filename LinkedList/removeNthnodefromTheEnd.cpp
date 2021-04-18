/**
//  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        //create a dummy node
        ListNode* dummy = new ListNode();
        //make the dummy node point to the head node
        dummy->next = head;
        //take 2 pointers slow and fast and make them point to the dummy node
        ListNode* slow = dummy;
        ListNode* fast = dummy;
        
        //increment fast till it becomes greater than value of n
        for(int i=1;i<=n;i++){
            fast = fast->next;
        }
        
        //while fast does not reach the last node move both slow and fast one node at a time
        while(fast->next!=NULL){
            fast = fast->next;
            slow = slow->next;
        }
        
        //now make the current slow node's next pointer point to it's next's next pointer
        slow->next = slow->next->next;
        
        return dummy->next;
    }
};