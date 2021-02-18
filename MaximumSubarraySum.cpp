class Solution {
    //https://leetcode.com/problems/maximum-subarray
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        int ans = nums[0];
        int dp[n];
        dp[0] = nums[0];
        for(int i =1;i<n;i++){
            dp[i] = max(nums[i],dp[i-1]+nums[i]);
            if(ans<dp[i])
                ans = dp[i];
        }
        // for(int i=0;i<n;i++){
        //     cout<<dp[i]<<" ";
        // }
        return ans;
    }
};