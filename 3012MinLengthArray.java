//3012 https://leetcode.com/problems/minimize-length-of-array-using-operations/
class Solution {
    public int minimumArrayLength(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int el = nums[0];
        int min = el, ct =0;
        for(int i=0;i<len;i++){
            if(nums[i]==el) ct++;
            if(nums[i]%el!=0){
                min = Math.min(min,nums[i]%el);
            }
        }
        if(min!=el || ct ==1) return 1;
        return (ct+1)/2;
    }
}
