class Solution {
    public int solve(int[] nums, int k){
        if(k<0) return 0;
        int count=0,i=0,j=0,n=nums.length,sum=0;

        for(;j<n;j++){
            sum+=nums[j];
            while(sum>k){
                sum-=nums[i++];
            }
            count+=j-i+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length,ans=0;
        if(len==0) return ans;
        for(int i=0;i<len;i++){
            if(nums[i]%2==0) nums[i]=0;
            else nums[i] = 1;
        }
        
        return solve(nums, k) - solve(nums,k-1);
    }
}