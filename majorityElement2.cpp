class Solution {
    //there can be one or more than one majority elmet
    //at most there can be 2 majority element as only 2 can be possibly more than (n/3)
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n1=-1, n2=-1, c1=0,c2=0;
        vector<int> res;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==n1){
                c1++;
            }else if(nums[i]==n2){
                c2++;
            }else if(c1==0){
                n1 = nums[i];
                c1=1;
            }else if(c2==0){
                n2=nums[i];
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1=c2=0;
        for(auto& x: nums){
            if(x==n1){
                c1++;
            }
            else if(x==n2){
                c2++;
            }
        }
        
        if(c1>(nums.size())/3) res.push_back(n1);
        if(c2>(nums.size())/3) res.push_back(n2);
        
        return res;
    }
};