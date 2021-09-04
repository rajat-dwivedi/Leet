class Solution {
    //two pointer approach
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast<nums.length){
            if(nums[fast]==0){
                fast++;
            }
            else{
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
                fast++;
            }
        }
    }
}