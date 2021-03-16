https://leetcode.com/problems/jump-game/
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int len = nums.size(),reach=0;
        if(len==0)
            return 0;
        for(int i=0;i<len;i++){
            if(reach<i)
                return false;
            reach = max(reach, i+nums[i]);
        }
        return true;
    }
};