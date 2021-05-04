class Solution {
public:
    bool rotateString(string A, string B) {
        if((A.length()==B.length()) && (B+B).find(A)!=string::npos)
            return true;
        else
            return false;
    }
};