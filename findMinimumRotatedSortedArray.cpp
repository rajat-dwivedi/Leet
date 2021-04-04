//solving using binary seach template 2
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0, end = nums.size()-1,mid;
        if(nums[0]<nums[end])
            return nums[0];
        while(start<end){
            mid = start +(end-start)/2;
            if(nums[mid]>=nums[0]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }
};