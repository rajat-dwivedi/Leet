//https://leetcode.com/problems/powx-n/submissions/
//time complexity is O(log2n)
class Solution {
public:
    double myPow(double x, int n) {
        //taking long to handle the edge case of -ve int largest number when converted to +ve overflows
        long long nn = n;
        
        if(nn<0) nn=-nn;
        
        double res = 1.0;
        while(nn){
            //if n is odd
            if(nn%2){
                //multiply single x in result 
                res = res*x;
                //reduce power by one
                nn=nn-1;
            }else{
                //multiply x to itself
                x=x*x;
                //make the power half
                nn=nn/2;
            }
        }
        
        //if n is negative then we give 1/result
        if(n<0){
            return double(1.0)/res;
        }else{
            return res;
        }
    }
};