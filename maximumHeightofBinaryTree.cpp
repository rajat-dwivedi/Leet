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
 //https://leetcode.com/problems/maximum-depth-of-binary-tree/
class Solution {
    int depth(TreeNode* n){
        if(n==NULL)
            return 0;
        return 1+max(depth(n->left),depth(n->right));
    }
public:
    int maxDepth(TreeNode* root) {
        return depth(root);
    }
};