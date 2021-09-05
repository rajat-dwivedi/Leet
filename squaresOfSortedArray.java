class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i=0, j=n-1,k=n-1;
        int[] ans = new int[n];
        
        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                ans[k--] = nums[i]*nums[i];
                i++;
            }else{
                ans[k--] = nums[j]*nums[j];
                j--;
            }
        }
        return ans;
    }
}