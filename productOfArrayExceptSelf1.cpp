// https://leetcode.com/problems/product-of-array-except-self/
//O(1) space (if we ignore res vector which take O(n) space)
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> res;
        
        int product = 1;
        
        //saving prefix multiplicaiton in the res array for now
        //res[i] = multiplication of nums[0] to nums[i]
        for(auto x: nums){
            product *= x;
            res.push_back(product);
        }
        
        //product holds multiplication of all numbers from right to left
        product = 1;
        for(int i=n-1;i>0;i--){
            //at i = prefix till i-1* product of all number to the right of i
            res[i] = res[i-1]*product;
            product *= nums[i];
        }
        
        //coner case of the first element, which is eqaul to product of all numbers to its right
        res[0] = product;
        
        return res;
    }
};