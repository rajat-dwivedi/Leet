//https://leetcode.com/problems/arithmetic-slices/
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size()<3)
            return 0;
        
        int len = A.size(), ans =0;
        //initialize with zero else will be filled with garbage values
        int t[len];
        memset(t,0,sizeof(t));
        
        for(int i=2;i<len;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                t[i]=t[i-1]+1;
                ans+=t[i];
            }
        }
        return ans;
    }
};