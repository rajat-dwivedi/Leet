//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
class Solution {
    public int countTriplets(int[] arr) {
        int count = 0, n = arr.length;
        for(int i=0;i<n;i++){
            int xor = arr[i];

            for(int k=i+1;k<n;k++){
                xor = xor^arr[k];
                if(xor==0){
                    count+=(k-i);
                }
            }
        }
        return count;
    }
}