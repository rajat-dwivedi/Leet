//https://leetcode.com/problems/132-pattern/
class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int n = nums.size(),mini=INT_MAX;
        for(int i =0;i<nums.size();i++){
            mini = min(mini,nums[i]);
            if(mini == nums[i]) continue;
            
            for(int k=n-1;k>i;k--){
                if(mini<nums[k] && nums[k]<nums[i]) return true;
            }
        }
        return false;
    }
};