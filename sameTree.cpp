/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
//https://leetcode.com/problems/same-tree/
class Solution {
    bool util(TreeNode* p, TreeNode* q){
        if(p!=NULL && q!=NULL){
            if((p->val==q->val)&&util(p->left,q->left)&&util(p->right,q->right))
                return true;
            else
                return false;
        }
        if(p==NULL && q==NULL)
            return true;
        else
            return false;
    }
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        return util(p,q);
    }
};