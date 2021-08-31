class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        unordered_map<int,int> mp;
        for(auto x: nums){
            mp[x] = true;
        }
        
        for(auto x: nums){
            if(mp.find(x-1)!=mp.end()){
                mp[x] = false;
            }
        }
        int len = 1;
        
        for(auto i: mp){
            int t=1;
            if(i.second==true){
                while(mp.find(i.first+t)!=mp.end()){
                    t++;
                }
            if(t>len)
                len = t;
            }
        }
        return len;
    }
};