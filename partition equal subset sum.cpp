//solution of equal sum partition problem
//solved using dynamic programming
class Solution {
    bool solve(vector<int> nums,int sum, int n){
        int t[n+1][sum+1];
        
        for(int j=0;j<=sum;j++)
            t[0][j]=0;
        
        for(int i=0;i<=n;i++)
            t[i][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                
                if(nums[i-1]>j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j]||t[i-1][j-nums[i-1]];
            }
        }
        return t[n][sum];
    }
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(auto x: nums)
            sum+=x;
        
        if(sum%2!=0)
            return false;
        else
            return solve(nums,sum/2,nums.size());
    }
};