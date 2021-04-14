//https://leetcode.com/problems/climbing-stairs/
class Solution {
public:
    int climbStairs(int n) {
        int t[n+1];
        t[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                t[i] = t[i-1];
            }else{
                t[i] = t[i-1]+t[i-2];    
            }
        }
        return t[n];
    }
};