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
// https://leetcode.com/problems/balanced-binary-tree/
// for each level you are doing a total scan of N, and there are logN levels.

class Solution {
	public:
		int height(TreeNode *root) {
			if(root == NULL)return 0;
			return max(height(root->left), height(root->right)) + 1;
		}
		bool isBalanced(TreeNode* root) {
			if(root == NULL)return true;
			return isBalanced(root->left) && isBalanced(root->right) && abs(height(root->left) - height(root->right)) <= 1;
		}
};