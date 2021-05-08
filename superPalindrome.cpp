//https://leetcode.com/problems/super-palindromes/discuss/174835/tell-you-how-to-get-all-super-palindrome(detailed-explanation)
//https://leetcode.com/problems/super-palindromes/
class Solution {
public:
    int superpalindromesInRange(string L, string R) {
        vector<long long> cds = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 1; i <= 10000; i++){
            string l = to_string(i),  r = l; reverse(r.begin(), r.end());
            cds.push_back(stoll(l+r));
            for(int d = 0; d < 10; d++)
                cds.push_back(stoll(l + to_string(d) + r));
        }
        int ans = 0;
        for(auto c: cds){
            // unsigned long long c2 = c*c;
            if( c>= stoll(L)/c &&  c<= stoll(R)/c && isP(to_string(c*c))) ans++;
        }
        return ans;
        
    }
    bool isP(string s){
       for(int i = 0, j = s.size()-1; i <= j; i++,j--) 
           if(s[i]!= s[j]) return false;
        return true;
    }
};