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
//https://leetcode.com/problems/binary-tree-postorder-traversal/
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if(!root)
            return {};
        stack<TreeNode* > st;
        vector<int> res;
        st.push(root);
        
        while(!st.empty()){
            TreeNode* root = st.top();
            st.pop();
            res.push_back(root->val);
            
            //doing the reverse of preorder
            if(root->left){
                st.push(root->left); 
            }
            
            //doing the reverse of preorder
            if(root->right){
                st.push(root->right);
            }
        }
        //time complexity of reverse if O(n)
        reverse(res.begin(),res.end());
        return res;
    }
};