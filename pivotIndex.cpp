//https://leetcode.com/problems/find-pivot-index/
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int sum =0,prev=0,next=0;
        for(auto& num: nums){
            sum+=num;
        }
        for(int i=0;i<nums.size();i++){
            if(i!=0){
                prev+=nums[i-1];
            }
            int cur = nums[i];
            sum = sum-cur;
            if(prev==sum ){
                return i;
            }
        }
        return -1;
    }
};