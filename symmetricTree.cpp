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
//https://leetcode.com/problems/symmetric-tree/
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode* >q1;
        queue<TreeNode* >q2;
        if(root==NULL)
            return true;
        q1.push(root->left);
        q2.push(root->right);
        while(!q1.empty() && !q2.empty()){
            TreeNode* p = q1.front();
            q1.pop();
            TreeNode* q = q2.front();
            q2.pop();
            if(p==NULL && q==NULL) continue;
            if(p==NULL || q==NULL) return false;
            if(p->val!=q->val) return false;
            q1.push(p->left);
            q1.push(p->right);
            q2.push(q->right);
            q2.push(q->left);
        }
        return true;
    }
};