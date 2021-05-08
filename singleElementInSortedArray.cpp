//https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int mid;
        if(nums.size()==1)
            return nums[0];
        int start = 0, end = nums.size()-1;
        if(nums[start]!=nums[start+1])
            return nums[start];
        if(nums[end]!=nums[end-1])
            return nums[end];
        while(start<=end){
            mid = start + (end-start)/2;
            
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])
                return nums[mid];
            //if the single number has not appeared then by rule the first same number appears at even index and the second same appears at odd index. After the single number appreas the rule flips
            if((mid%2)==0 && nums[mid]==nums[mid+1]
              ||(mid%2)==1 && nums[mid]==nums[mid-1])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
};