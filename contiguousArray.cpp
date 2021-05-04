//https://leetcode.com/problems/contiguous-array/
//finding longest contiguous subarray of equal 1s and 0s
/* we treat 0 as -1 to cumulative sum.
store the cumulative sum in a map and check if such sum has already occured
previous occurance of such some at index j shows subarray having 0 sum between j and i(current index)
*/
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
    
        unordered_map<int, int>m;
        //0 sum before the start of array
        m[0]=-1;
        int ans = 0,total=0;
        
        for(int i =0;i<nums.size();i++){
            if(nums[i]==0)
                total += -1;
            else
                total+=1;
            if(m.find(total)!=m.end()){
                int len = i-m[total];
                if(len>ans)
                    ans = len;
            }else
                m[total] = i;
        }
        return ans;
    }
};
