//https://leetcode.com/problems/subarray-sum-equals-k/
// Input : arr[] = {10, 2, -2, -20, 10}, 
//         k = -10
// Output : 3
// Input : arr[] = {1, -1, 1, -1}, 
//         k = 0
// Output : 4
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        int n = nums.size();
        int cursum = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            cursum+=nums[i];
            if(cursum == k)
                ans++;
            if(m.find(cursum-k)!=m.end()){
                    ans+=m[cursum-k];
                }
            m[cursum]++;
        }
        return ans;
    }
};
