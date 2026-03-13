//https://leetcode.com/problems/complement-of-base-10-integer/
// 1009complementOfBase10Integer
class Solution {
    public int bitwiseComplement(int n) {
        int x = 1;
        while(n>x){
            x = x<<1;
            x+=1;
        }
        return x-n;
    }
}