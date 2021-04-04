//https://leetcode.com/problems/kth-largest-element-in-an-array/
//naive solution. Just sort the array in reverse order and return the kth largest element
//the time complexity of this solution is O(NlogN)
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end(),greater<int>());
        return nums[k-1];
        // return 0;
    }
};