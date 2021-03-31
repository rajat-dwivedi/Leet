//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    int solveleft(vector<int>& nums, int target){
        int res=-1;
        int start =0, end =nums.size()-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                res = mid;
                end=mid-1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    
    int solveright(vector<int>& nums, int target){
        int res=-1;
        int start =0, end =nums.size()-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                res = mid;
                start=mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;
        int left = solveleft(nums, target);
        int right = solveright(nums, target);
        ans.push_back(left);
        ans.push_back(right);
        return ans;
    }
};