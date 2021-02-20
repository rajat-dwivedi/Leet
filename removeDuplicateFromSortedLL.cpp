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
public:
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode*  prev; ListNode* cur;
        if(head == NULL)
            return head;
        prev = head;
        cur = head->next;
        while(cur!=NULL){
            if(prev->val == cur->val ){
                prev->next = cur->next;
                cur = cur->next;
            }else{
                prev = cur;
                cur = cur->next;
            }
        }
        return head;
    }
};