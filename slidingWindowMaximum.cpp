//https://leetcode.com/problems/sliding-window-maximum/
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq;
        int n = nums.size();
        vector<int> res;
        for(int i=0;i<n;i++){
            while(!dq.empty() && dq.back()<nums[i]) dq.pop_back();
            dq.push_back(nums[i]);
            if(i>=k-1){
                res.push_back(dq.front());
                if(nums[i-k+1]==dq.front()) dq.pop_front();
            }
        }
        return res;
    }
};