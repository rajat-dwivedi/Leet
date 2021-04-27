// https://leetcode.com/problems/find-the-duplicate-number/
//method to find duplicate number without changing the array
//uses the method of finding loop in a linked list
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
};