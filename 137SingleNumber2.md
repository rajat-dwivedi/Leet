//https://leetcode.com/problems/single-number-ii/
class Solution {
public int singleNumber(int[] nums) {
int sum = 0, res = 0;
for(int i=0;i<32;i++){
// res = res<<i;
sum=0;
for(int num: nums){
num = num>>i;
if((num & 1)==1){
sum++;
}
}
sum=sum%3;
if(sum!=0)
{
sum=sum<<i;
res = res|sum;
}
}
return res;
}
}
