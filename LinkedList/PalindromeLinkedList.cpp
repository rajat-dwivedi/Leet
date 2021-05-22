/**
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
    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL;
        ListNode* ne = NULL;
        while(head){
            ne = head->next;
            head->next = prev;
            prev = head;
            head = ne;
        }
        return prev;
    }
public:
    bool isPalindrome(ListNode* head) {
        if(!head||head->next==NULL)
            return true;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next && fast->next->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        //reverse the linked list after the slow pointer
        slow->next = reverse(slow->next);
        
        //move the slow to the start of the reversed part of LL
        slow = slow->next;
        
        while(slow){
            if(slow->val != head->val)
                return false;
            slow = slow->next;
            head = head->next;
        }
        
        return true;
    }
};