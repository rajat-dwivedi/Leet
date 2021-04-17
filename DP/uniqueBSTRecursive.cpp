// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    int solve(int n){
        if(n==0)
            return 1;
        int res = 0;
        
        for(int i=0;i<n;i++){
            res += solve(i) * solve(n-i-1);
        }
        return res;
    }
public:
    int numTrees(int n) {
       return solve(n); 
    }
};