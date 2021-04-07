// https://leetcode.com/problems/determine-if-string-halves-are-alike/
class Solution {
    int isvowel(char ch){
        ch = tolower(ch);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        else
            return false;
    }
    int check(string s){
        int count = 0;
        for(auto ch: s){
            if(isvowel(ch))
                count++;
        }
        return count;
    }
public:
    bool halvesAreAlike(string s) {
        // s = s.tolower();
        int len = s.length();
        string a = s.substr(0,len/2);
        string b = s.substr(len/2,s.length()+len/2);
        // print()
        if(check(a)==check(b))
        return true;
        else
            return false;
    }
};