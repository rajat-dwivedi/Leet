//https://leetcode.com/problems/sort-array-by-parity/
class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        if(nums.size()==1)
            return nums;
        int i=0, j= nums.size()-1;
        while(i<j){
            //if i is already even 
            if(nums[i]%2==0){
                i++;
            }else{
                //odd, odd
                if(nums[j]%2!=0){
                    j--;
                }else{
                    //odd, even
                    swap(nums[i],nums[j]);
                    i++;
                    j--;
                }
            }
        }
        return nums;
    }
};

