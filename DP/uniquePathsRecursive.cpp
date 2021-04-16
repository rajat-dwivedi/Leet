// https://leetcode.com/problems/unique-paths/
class Solution {
    int solve(int i, int j,int m, int n){
        if(i==m && j==n)
            return 1;
        if(i>m || j>n)
            return 0;
        return solve(i+1,j,m,n)+solve(i,j+1,m,n);
            
    }
public:
    int uniquePaths(int m, int n) {
        return solve(1,1,m,n);
    }
};