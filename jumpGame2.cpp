//https://leetcode.com/problems/jump-game-ii/
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int dp[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0; i--){
            int steps = nums[i];
            int null = -1;
            int min = INT_MAX;
            int inf = INT_MAX;
            for(int j=1;j<=steps && i+j<n;j++ ){
                if(dp[i+j]!=inf && dp[i+j]<min){
                    min = dp[i+j];
                }
            }
            if(min!=inf){
                dp[i] = min+1;
            }else{
                dp[i] = inf;
            }
        }
        return dp[0];
    }
};