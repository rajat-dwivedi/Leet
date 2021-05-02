// https://leetcode.com/problems/product-of-array-except-self/
//space O(N) for each profix and suffix array 

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> pre(n+1);
        vector<int> suf(n+1);
        vector<int> ans(n);
        pre[0]= 1;
        int j =1;
        for(int x : nums){
            pre[j] = pre[j-1]*x;
            j++;
        }
        suf[n]=1;
        for(int i=n-1;i>=0;i--){
            suf[i] = nums[i]*suf[i+1];
        }
        int i=0;
        for(int x : nums){
           ans[i] = pre[i]*suf[i+1];
            i++;
        }
        return ans;
    }
};