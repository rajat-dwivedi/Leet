// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if(len==0 || len <2)
            return 0;
        int maxProfit = 0, minprice = prices[0];
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]){
                maxProfit = max(maxProfit, prices[i]-minprice);
            }else{
                minprice = min(minprice, prices[i]);
            }
        }
        return maxProfit;
    }
};