// https://leetcode.com/problems/power-of-three/
class Solution {
public:
    bool isPowerOfThree(int n) {
        //since 1162261467 is 3^19, 3^20 is greater than limits of int
        return n>0 && 1162261467 % n == 0;
    }
};