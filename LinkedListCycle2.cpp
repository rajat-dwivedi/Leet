class Solution {
    //https://leetcode.com/problems/linked-list-cycle-ii/
public:
    ListNode *detectCycle(ListNode *head) {
        int count=0, flag=0;
        if(head==NULL)
            return NULL;
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast && fast->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
            if(fast==slow){
                flag = 1;
                break;
            }
        }
        if(flag){
            slow=head;
            while(slow!=fast){
                if(slow==fast)
                    break;
                slow=slow->next;
                fast = fast->next;
            }
        }else{
            return NULL;
        }
        return slow;
    }
};