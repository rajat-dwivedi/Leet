//https://leetcode.com/problems/binary-gap/
//868binaryGap

class Solution {
    public int binaryGap(int n) {
        int first = -1, ans = 0;
        for(int i=0;i<32;i++){
            int temp = n & (1<<i);
            if(temp>0){
                if(first==-1){
                    first = i;
                }else{
                    ans = Math.max(ans,i-first);
                    first = i;
                }
            }
        }
        return ans;
    }
}