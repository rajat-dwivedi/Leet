//https://leetcode.com/problems/minimum-array-end/
class Solution {
    public long minEnd(int n, int x) {
        //getting the ones in origianl x
        int []xbit=new int[64];
        //the last number will have 1s and 0s like the binary represntation of n-1
        n=n-1;
        int nbit[]=new int[64];
        //converting an interger into its binary reprsentation
        for(int i=0;i<32;i++){
            //converting x and n into its bit representation
            if((x & (1<<i))!=0){
                xbit[i]=1;
            }
             if((n & (1<<i))!=0){
                nbit[i]=1;
            }
        }
        // System.out.println(Arrays.toString(xbit));
        // System.out.println(Arrays.toString(nbit));
       int i=0;
       int j=0;
       while(i<xbit.length && j<nbit.length){
           if(xbit[i]==0){
            xbit[i++]=nbit[j++];
           }
           else{
            i++;
           }
       }
                
         
        long summ=0;
        // System.out.println(Arrays.toString(xbit));
        //converting a binary rep array to decimal number
        for(int k=0;k<64;k++){
              summ+=(xbit[k]*Math.pow(2,k));
            // summ = summ*2+xbit[k];
        }
        return summ;
        
    }
}