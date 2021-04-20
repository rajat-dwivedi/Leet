//https://leetcode.com/problems/binary-tree-preorder-traversal/
vector<int> preorderTraversal(TreeNode* root) {
        if (!root) {
            return {};
        }
        
        std::stack<TreeNode*> st;
        std::vector<int> res;
        
        st.push(root);
        
        while(!st.empty()) {
            root = st.top(); st.pop(); 
            res.push_back(root->val);
            
            if (root->right) {
                st.push(root->right);
            }
            
            if (root->left) {
                st.push(root->left);
            }
        }
        
        return res;
    }