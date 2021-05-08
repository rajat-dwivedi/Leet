//https://leetcode.com/problems/jewels-and-stones/
/* tc - O(J+S) sc-O(J)
contains function works in O(1) tc*/
class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        unordered_set<char> s(jewels.begin(), jewels.end());
        int ans = 0;
        for(char ch: stones){
            if(s.count(ch)!=0)
                ans++;
        }
        return ans;
    }
};