class Solution {
    //https://leetcode.com/problems/combination-sum-ii/
    void solve(int ind, int target, vector<int>& temp, vector<vector<int>>&res, vector<int>& nums){
        if(target==0){
            res.push_back(temp);
            return;
        }
        
        for(int i=ind; i<nums.size(); i++){
            if(i>ind && nums[i]==nums[i-1])
                continue;
            if(nums[i]>target)
                break;
            temp.push_back(nums[i]);
            solve(i+1, target-nums[i], temp, res, nums);
            temp.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int> temp;
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        solve(0, target, temp, res, candidates);
        return res;
    }
};