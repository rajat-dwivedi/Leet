#include<bits/stdc++.h>
using namespace std;
/* for an even length linked list this algo gives the first middle node by stopping fast one befor the end node
example 
1-2-3-4-5-6
then slow points to 3 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next)
            slow = slow->next, fast = fast->next->next;
        return slow;
    }
};