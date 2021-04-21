constructBTfromInorderPreorderTraversal.cpp
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
// class Solution {
// public:
//     int ind = 0;
//     TreeNode* solve(vector<int>& preorder, int start, int end,unordered_map<int, int> mp){
//         if(end<start)
//             return NULL;
        
//         TreeNode* root = new TreeNode(preorder[ind]);
//         // cout<<root->val<<endl;
//         int mid = mp[preorder[ind]];
//         ind++;
//         root->left = solve(preorder, start, mid-1,mp);
//         root->right = solve(preorder, mid+1, end,mp);
//         return root;
//     }
//     TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
//         unordered_map<int, int> mp;
//         for(int i=0;i<inorder.size();i++){
//             mp[inorder[i]] = i;
//         }
//         return solve(preorder,0,preorder.size()-1,mp);
//     }
// };
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int inPos = 0;
        int prePos = 0;
        return build(preorder, inorder, INT_MIN, inPos, prePos);
    }
    TreeNode* build(vector<int>& preorder, vector<int>& inorder, int stop, int& inPos, int& prePos){
        if(prePos >= preorder.size()) return NULL;
        if(inorder[inPos] == stop) {inPos++; return NULL;}
        TreeNode* node = new TreeNode(preorder[prePos]);
        prePos++;
        node->left = build(preorder, inorder, node->val, inPos, prePos);
        node->right = build(preorder, inorder, stop , inPos, prePos);
        return node;
    }
};