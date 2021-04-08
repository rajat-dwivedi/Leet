// https://leetcode.com/problems/longest-continuous-increasing-subsequence/
class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        int ans = 1,count =1,cur=nums[0];
        for(int i=1;i<nums.size();i++){
            if(nums[i]>cur){
                count++;
                
            }else{
                count=1;
            }
            cur=nums[i];
            ans = max(ans, count);
        }
        return ans;
    }
};