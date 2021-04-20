
//https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode* > st;
        vector<int> sol;
        while(root || !st.empty() ){
            while(root){
                st.push(root);
                root = root->left;
            }
            root = st.top();
            st.pop();
            sol.push_back(root->val);
            root = root->right;
        }
        return sol;
    }
};