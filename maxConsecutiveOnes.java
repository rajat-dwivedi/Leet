public int findMaxConsecutiveOnes(int[] nums) {
    //This question is very similar to moving zero. And below is my solution based on two pointer. The idea is the slow always point to the first 1 of a set consecutive 1s.
        int slow = 0, fast = 0;
        int max = 0;
        while(fast<nums.length)
        {
            if(nums[fast]==1)
                fast++;
            else if(nums[fast]==0)
            {
                int len = fast - slow;
                max = Math.max(max, len);
                
                slow = fast;
                fast++;
                slow++;
            }
        }
        max = Math.max(max, fast-slow);
        return max;
}