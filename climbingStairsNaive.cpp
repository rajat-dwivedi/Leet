// https://leetcode.com/problems/climbing-stairs/
//a naive recursive approach to solve the climbing stairs problem
class Solution {
    int solve(int n){
        if(n==0 || n==1)
            return 1;
        return solve(n-2)+solve(n-1);
    }
public:
    int climbStairs(int n) {
        return solve(n);
    }
};