//https://leetcode.com/problems/number-complement/
class Solution {
public:
    int findComplement(int num) {
        int res = 0;
        while(num>res) res = res*2+1;
        return res^num;
    }
};