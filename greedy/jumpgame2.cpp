//https://leetcode.com/problems/jump-game-ii/submissions/
class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps = 1;
        int end = nums[0];
        int farthest = nums[0];
        
        if(nums[0]==0 || nums.size()==1)
            return 0;
        
        for(int i=0;i<nums.size();i++){
            if(i==nums.size()-1){
                break;
            }
            farthest = max(farthest, i+nums[i]);
            if(i==end){
                end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
};