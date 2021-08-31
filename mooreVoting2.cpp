class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ans = 0,count=0,el;
        for(auto x: nums){
            if(count==0){
                el = x;
            }
            if(el==x){
                count+=1;
            }else{
                count-=1;
            }
        }
        return el;
    }
};