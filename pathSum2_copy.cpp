class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>>  result;
        vector<int> solution;
        help(root, sum, result, solution);
        return result;
    }
    
    void help(TreeNode* root, int sum, vector<vector<int>> &result, vector<int> solution){
        if(!root)   return;
        //leat node
        if(!root->left && !root->right && root->val==sum) {
            solution.push_back(root->val);
            result.push_back(solution);
            return;
        }
        //not leaf node
        solution.push_back(root->val);
        if(root->left)  {
            help(root->left, sum-root->val, result, solution);
        }
        if(root->right)  {
            help(root->right, sum-root->val, result, solution);
        }
    }
};