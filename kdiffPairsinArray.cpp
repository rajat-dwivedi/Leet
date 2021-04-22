//https://leetcode.com/problems/k-diff-pairs-in-an-array
class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        unordered_set<int> s;
        for(auto x: nums){
            if(m.count(x+k)){
                s.insert(x);
            }
            if(m.count(x-k)){
                s.insert(x-k);
            }
            m[x]+=1;
        }
        return s.size();
    }
};