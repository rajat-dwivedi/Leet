//1652 defuse the bomb
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if(k==0) return res;
        int csum = 0;
        int start = 1, end = k;
        if(k<0){
            k=-k;
            start = len-k;
            end = len-1;
        }
        for(int i=start;i<=end;i++) csum+=code[i];
        for(int i=0;i<len;i++){
            res[i] = csum;
            csum-=code[(start++)%len];
            csum+=code[(++end)%len];
        }
        return res;
    }
}