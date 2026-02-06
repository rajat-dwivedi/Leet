// https://leetcode.com/problems/minimum-removals-to-balance-array/
class Solution {
    public int minRemoval(int[] nums, int k) {
        int len = nums.length;
        if(len==0 || len==1) return 0;
        Arrays.sort(nums);
        int ans = 0,i=0,j=0;
        while(j<len){
            while((long)nums[i]*k<(long)nums[j]){
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return len-ans;
    }
}