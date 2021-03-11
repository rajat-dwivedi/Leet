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
//https://leetcode.com/problems/path-sum-ii/
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>>sols;
        vector<int> sol;
        solve(sols, sol, root, targetSum);
        return sols;
    }
    void solve(vector<vector<int>>& sols, vector<int>& sol, TreeNode* root, int TS){
        if(!root)
            return;
        sol.push_back(root->val);
        if(root->left==NULL && root->right==NULL && root->val == TS){
            sols.push_back(sol);
        }
        solve(sols, sol, root->left, TS-root->val);
        solve(sols, sol, root->right, TS-root->val);
        sol.pop_back();
    }
};