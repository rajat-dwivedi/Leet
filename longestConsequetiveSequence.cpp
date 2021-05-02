//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        unordered_set<int> s(nums.begin(), nums.end());
        int ans=1;
        for(auto num: nums){
            if(!s.count(num-1)){
                int cur = num;
                int streak = 1;
                
                while(s.count(cur+1)!=0){
                    cur = cur+1;
                    streak+=1;
                }
                
                ans = max(ans,streak);
            }
        }
        return ans;
    }
};