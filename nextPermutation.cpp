class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size(),j,k;
        if(n==1)
            return;
        //start traversing from right to left to find first k such that nums[k]<nums[k+1]
        for(k=n-2;k>=0;k--){
            if(nums[k]<nums[k+1])
                break;
        }
        
        //if no such k is found that means the number is in decreasing order then just return the reverse of that number
        if(k<0){
            reverse(nums.begin(), nums.end());
            return;
        }else{
            for(j=n-1;j>k;j--){
                if(nums[j]>nums[k])
                    break;
            }
            
            swap(nums[j], nums[k]);
            reverse(nums.begin()+k+1, nums.end());
        }
    }
};