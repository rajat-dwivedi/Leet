// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    //finding the first position having element greater than or equal to x
    int findp(vector<int>& nums, int x){
        int end = nums.size()-1, start = 0, mid;
        int ans = nums.size();
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid]>=x){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0)
            return {-1,-1};
        int first = findp(nums, target);
        int last = findp(nums, target+1)-1;
        //if number not found than both first will be k(any position) and last will be (k-1)
        //so the statment given below will hold true only when number number is found
        if(first<=last){
            return {first, last};
        }else{
            return {-1, -1};
        }
    }
};