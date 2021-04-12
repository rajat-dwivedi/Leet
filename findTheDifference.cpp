//https://leetcode.com/problems/find-the-difference/
class Solution {
public:
    char findTheDifference(string s, string t) {
        char res = 0;
        for(auto& ch:s) res = res^ch;
        for(auto& ch : t) res = res^ch;
        return res;
    }
};