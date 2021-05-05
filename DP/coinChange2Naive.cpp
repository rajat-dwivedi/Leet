//https://leetcode.com/problems/coin-change-2/
//similar to unbounded knapsack
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(amount==0)
            return 1;
        int n = coins.size();
         int t[n+1][amount+1];
        
        //if number of coins = 0 then 0 ways to make the amount
        for(int j=0;j<=amount;j++)
            t[0][j] =0;
        
        //if amount = 0 then there is always 1 way to make the amount
        for(int i=0;i<=n;i++)
            t[i][0] =1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
                    
                }else{
                    //if the value of the current coin is greater than the sum we are trying to make
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][amount];
    }
};