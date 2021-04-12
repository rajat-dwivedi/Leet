//https://leetcode.com/problems/single-number-iii/
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> res;
        int x=0,y=0,total=0,mask = 1;
        for(auto& num: nums){
            total = total^num;
        }
        
        //getting the rightmost set bit for total
        while((total&mask)==0){
            mask = mask<<1;
        }
        
        for(auto& num: nums){
            if(num & mask){
                x= x^ num;
            }else{
                y = y^num;
            }
        }
        res.push_back(x);
        res.push_back(y);
        return res;
    }
};