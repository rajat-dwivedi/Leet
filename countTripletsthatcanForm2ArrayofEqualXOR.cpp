//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
class Solution {
public:
    int countTriplets(vector<int>& arr) {
        //initialize the return ans as 0
        int ans=0;
        for(int i=0;i<arr.size()-1;i++){
            int val = arr[i];
            for(int k = i+1;k<arr.size(); k++){
                //taking out the xor of values from i till k
                val = val ^ arr[k];
                
                //if that xor is 0 that means there will be a triplet
                
                if(val == 0){
                    //the number of triplets will be (k-i)   
                    ans += (k-i);
                }
            }
        }
        return ans;
    }
};