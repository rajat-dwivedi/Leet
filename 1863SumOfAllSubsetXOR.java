//1863 https://leetcode.com/problems/sum-of-all-subset-xor-totals/
//m1 = O(n*2^n)
class Solution {
    public int subsetXORSum(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for(int mask=0;mask<(1<<len);mask++){
            int xor =0;
            for(int i=0;i<len;i++){
                int temp = mask&(1<<i);
                if(temp>0){
                    xor=xor^nums[i];
                }
            }
            ans +=xor;
        }
        return ans;
    }
}