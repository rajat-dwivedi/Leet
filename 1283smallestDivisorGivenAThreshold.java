//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long sum = 0;
        int l = 1, r = 1;
        for (int num : nums) {
            sum += num;
            r = Math.max(r, num);
        }
        if (sum <= threshold) return 1;
        while (l < r) {
            int div = l + (r-l)/2;
            sum = 0;
            for (int i = 0; i < nums.length && sum <= threshold; i++) {
                sum += (int)Math.ceil((double)nums[i]/div);
            }
            if (sum > threshold) l = div+1;
            else r = div;
        }
        return l;
    }
}