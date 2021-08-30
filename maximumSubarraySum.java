class Solution {
    public int maxSubArray(int[] nums) {
        int osum=nums[0];
        int csum=nums[0];
        for(int i=1;i<nums.length;i++){
            csum = Math.max(nums[i],csum+nums[i]);
            if(csum>osum){
                osum = csum;
            }
        }
        return osum;
    }
}