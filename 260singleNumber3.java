//https://leetcode.com/problems/single-number-iii/
class Solution {
    public int[] singleNumber(int[] nums) {
        int xyxor = 0;
        for(int num: nums){
            xyxor = xyxor^num;
        }
// 1110
// 1100
//taking out the rightmost set bit mask
int temp = xyxor & (xyxor-1);
int rmsbm =xyxor^temp;
        
        int x=0, y=0;
        for(int num: nums){
            //xor of all the numbers where rmsbm is 0
            if((rmsbm & num)==0){
                x = x^num;
            }else{
                //xor of all the numbers where rmsbm is not 0 (it can be any number other than 0 not necessarily 1)
                y = y^num;
            }
        }
        
        return new int[]{x,y};
    }
}




