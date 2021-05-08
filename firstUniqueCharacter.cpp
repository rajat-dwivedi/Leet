//https://leetcode.com/problems/first-unique-character-in-a-string/
//tc - O(n) twice
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int> mp;
        
        for(int i=0;i<s.size();i++){
            if(mp.find(s[i])!=mp.end())
                mp[s[i]] = INT_MAX;
            else
                mp[s[i]] = i;
        }
        int ans = INT_MAX;
        for(auto p: mp){
            ans = min(ans,p.second);
        }
        if(ans == INT_MAX)
            return -1;
        else
            return ans;
    }
};