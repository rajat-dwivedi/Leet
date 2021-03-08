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
//https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if(!root) return true;
        stack<TreeNode* > s;
        TreeNode* pre = NULL;
        while(root || !s.empty()){
            while(root){
                s.push(root);
                root = root->left;
            }
            root = s.top();
            s.pop();
            if(pre!=NULL && root->val<=pre->val) return false;
            pre = root;
            root=root->right;
        }
        return true;
    }
};