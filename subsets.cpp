//https://leetcode.com/problems/subsets/
class Solution {
    void solve(vector<vector<int>>& list, vector<int>& temp, vector<int>& nums, int begin){
        list.push_back(temp);
        for(int i=begin; i<nums.size(); i++){
            temp.push_back(nums[i]);
            solve(list,temp,nums,i+1);
            temp.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> list;
        // sort(nums.begin(),nums.end());
        vector<int> temp;
        solve(list,temp,nums,0);
        return list;
    }
};
