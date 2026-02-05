//3379 transformed array
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                res[i] = nums[(i+nums[i])%len];
            }
            else if(nums[i]<0){
                res[i]=nums[(i-Math.abs(nums[i])%len+len)%len];
            }else{
                res[i]=nums[i];
            }
        }
        return res;
    }
}