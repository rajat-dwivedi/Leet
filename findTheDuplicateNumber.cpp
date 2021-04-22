// https://leetcode.com/problems/find-the-duplicate-number/
//similar to one missing and one repeating solution using swap sort
//time complexity = O(n) space O(1)
//naive solution use maps - space O(n)
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int res;
        for(int i =0;i<nums.size(); i++){
            while(nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i])
                {
                    res = nums[i];
                    break;
                }else{
                    swap(nums[i],nums[nums[i]-1]);
                }     
            }
        }
        return res;
    }
};
