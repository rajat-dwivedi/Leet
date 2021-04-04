//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
//solved using binary search template 2
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int start = 0, end = nums.size()-1,mid;
        if(nums.size()==1)
            return 0;
        while(start<end){
            mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1])
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
};