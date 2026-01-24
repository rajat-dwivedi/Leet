//1052 grumpy customers
class Solution {
    public int maxSatisfied(int[] cust, int[] gru, int min) {
        int len = cust.length, sum = 0;
        for(int i=0;i<len;i++){
            if(gru[i]==0){
                 sum+=cust[i];
                 cust[i] = 0;
            }
        }
        int tempsum =0, maxSum = 0,s=0,e=0;
        while(e<len){
            tempsum+=cust[e];
            while(e-s+1>min){
                tempsum-=cust[s++];
            }
            maxSum = Math.max(tempsum, maxSum);
            e++;
        }
        return sum+maxSum;

    }
}