// https://leetcode.com/problems/sort-colors/
//naive1 = sort the array tc-nlogn sc-1
//naive2 = counting sort tc - n space - 2
//all numbers left of low will be 0, all numbers right of high will be 2
//three cases
//if mid = 0 swap with lo and increment both
//if mid = 2 swap with high,keep mid same and dec high
//if mid = 1 increment mid
class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        int low = 0, mid = 0, high = nums.size()-1;
        if(nums.size()==0)
            return;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums[low++],nums[mid++]);
            }else if(nums[mid]==2){
                swap(nums[mid],nums[high--]);
            }else{
                mid++;
            }
        }
    }
};