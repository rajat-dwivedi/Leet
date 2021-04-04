//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==1)
            return nums[0];
        if(nums[0]<nums[nums.size()-1]){
            return nums[0];
        }
        int n = nums.size();
        int start = 0, end = nums.size()-1, mid,prev,next;
        while(start<=end){
            mid = start + (end-start)/2;
            prev = (mid-1+n)%n, next = (mid+1)%n;
            //the property of smallest element is that its smaller than both its neighbours
            if(nums[prev]>nums[mid] && nums[next]>nums[mid])
                break;
            //if the array from start till mid is sorted that means pivot lies in the opposite unsorted part
            else if(nums[mid]>=nums[0]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return nums[mid];
    }
};