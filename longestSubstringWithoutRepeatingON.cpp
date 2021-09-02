class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size(), left=0, right=0,ans=0;
        vector<int> f(256, -1);
        while(right<n){
            if(f[s[right]]!=-1) left = max(left, f[s[right]]+1);
            
            f[s[right]]=right;
            ans = max(ans, (right-left+1));
            right++;
        }
        return ans;
    }
};