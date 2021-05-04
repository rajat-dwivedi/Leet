// https://leetcode.com/problems/non-decreasing-array/
/*seems simple but its not
changing any value in the array affects its future or past answer*/
//tc - O(n) sc- O(1)
class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
     int count = 0;
        if(nums.size()==1) return true;
        for(int i=1;i<nums.size();i++){
            if(nums[i-1]>nums[i]){
                if(i==1||nums[i-2]<=nums[i]){
                    nums[i-1]=nums[i];
                    count++;
                }else{
                    nums[i]=nums[i-1];
                    count++;
                }
            }
        }
        return count<=1;
    }
};