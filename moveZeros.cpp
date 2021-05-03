// https://leetcode.com/problems/move-zeroes/
//two pointer apprach to solve the problem
//both two pointers start at 0
//left pointer points to first 0 to the left side of right pointer 
//whenever right is at a 0 value we just increase right pointer
// at a non zero value we swap left pointer and right pointer values
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left=0, right = 0;
        while(right<nums.size()){
            if(nums[right]==0){
                right++;
            }else{
                swap(nums[right],nums[left]);
                right++; 
                left++;
            }
        }
    }
};