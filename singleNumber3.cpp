//https://leetcode.com/problems/single-number-iii/
class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        unordered_map<int, int> mp;
        vector<int> res;
        for(auto& num: nums){
            mp[num]++;
        }
        
        for(auto it = mp.begin(); it!=mp.end(); it++){
            if(it->second<2){
                res.push_back(it->first);
            }
        }
        
        return res;
    }
    
};