//https://leetcode.com/problems/zero-array-transformation-i/
//method 0 - brute force
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for(int[] query: queries){
            int s = query[0], e = query[1];
            for(int i=s;i<=e;i++){
                if(nums[i]!=0)nums[i]-=1;
            }
        }
        for(int num: nums){
            if(num!=0) return false;
        }
        return true;
    }
}