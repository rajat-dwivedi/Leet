//https://leetcode.com/problems/top-k-frequent-elements/submissions/
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        //create a unordered map to store frequency of array elements
        unordered_map<int, int > mp;
        
        //creating a min heap of pair. The first part of pair will be frequency
        priority_queue<pair<int, int>,vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> res;
        
        //storing the frequency of array elemenets in the map
        for(auto& i: nums){
            mp[i]++;
        }
        
        // pushing the elements in min heap on basis of frequency
        for(auto it = mp.begin(); it!=mp.end(); it++){
            pq.push({it->second, it->first});
            //if size of min heap is greater than k then remove the top element
            if(pq.size()>k)
                pq.pop();
        }
        
        //push the most frequent elements in res vetor
        while(!pq.empty()){
            auto it = pq.top();
            pq.pop();
            res.push_back(it.second);
        }
        
        return res;
    }
};