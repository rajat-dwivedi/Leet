// https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans =0, len=nums.length, s=0,e=0,count=0;
        if(len==0) return ans;
        while(e<len){
            if(nums[e]==0) count++;
            while(count>k){
                if(nums[s]==0) count--;
                s++;
            }
            ans = Math.max(ans, e-s+1);
            e++;
        }
        return ans;
    }
}