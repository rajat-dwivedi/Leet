// https://leetcode.com/problems/4sum/
//time complexty - O(n^3) 3 loops + O(nlogn) sorting
//space - O(1) ignoring result vector
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        int n = nums.size();
        if(n<4) return {};
        
        //sorting the given array O(nlogn)
        sort(nums.begin(), nums.end());
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                //inner target
                int t2 = target - nums[i]-nums[j];
                int start = j+1;
                int end = nums.size()-1;
                
                while(start<end){
                    
                    if(nums[start]+nums[end]<t2) start++;
                    else if(nums[start]+nums[end]>t2) end--;
                    else{
                        vector<int> temp(4);
                        temp[0] = nums[i];
                        temp[1] = nums[j];
                        temp[2] = nums[start];
                        temp[3] = nums[end];
                        res.push_back(temp);

                        while(start<end && nums[start]==temp[2]) start++;
                        while(start<end && nums[end] == temp[3]) end--;
                    }

                    
                }
                    //processing the duplicates of number 2
                //for loop will further make j+=1 thus we check for j+1 here
                    while(j+1<n && nums[j+1]==nums[j]) ++j;
            }
            //processing the duplicates of number 1
            //for loop will further make i+=1 thus we check for i+1 here
            while(i+1<n && nums[i+1]==nums[i]) ++i;
        }
        
        return res;
    }
};