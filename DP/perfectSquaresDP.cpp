//https://leetcode.com/problems/perfect-squares/
class Solution {
public:
    //tc = O(Nroot(N))
    int numSquares(int n) {
        //t array stores the least number of perfect squares that sum to n
        //the most of t[i] is i as any number can be 1^2+1^2...i times
        int t[n+1];
        for(int i=0;i<=n;i++){
            t[i] = i;
        }
        
        //for i=1,2,3 the answer is i thus we start from 4
        for(int i=4;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                t[i] = min(t[i], 1+t[i-j*j]);
            }
        }
        
        return t[n];
    }
};