//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//tc - O(len(s))*alphabet size
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int len = s.size();
        if(p.size()>len)
            return {};
        int left=0, right = 0;
        vector<int> ans;
        vector<int> hash(26,0);
        vector<int> phash(26,0);
        
        while(right<p.size()){
            hash[s[right]-'a']+=1;
            phash[p[right]-'a']+=1;
            right++;
        }
        
        right-=1;
        
        while(right<len){
            
            if(phash == hash){
                ans.push_back(left);
            }
            right+=1;
            if(right!=len){
                hash[s[right]-'a']+=1;
            }
            hash[s[left]-'a'] -=1;
            left++;
        }
        return ans;
    }
};