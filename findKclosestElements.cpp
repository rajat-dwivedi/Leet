//https://leetcode.com/problems/find-k-closest-elements/
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> res;
        priority_queue<pair<int, int>> pq;
        for(int i =0;i<arr.size();i++){
            pq.push({abs(x-arr[i]),arr[i]});
            if(pq.size()>k)
                pq.pop();
        }
        
        while(!pq.empty()){
            auto p = pq.top();
            pq.pop();
            res.push_back(p.second);
        }
        sort(res.begin(), res.end());
        return res;
    }
};