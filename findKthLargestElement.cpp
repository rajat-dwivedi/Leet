//https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //heap solution with time complexity of O(nlogk) 
        //when asked the largest then create a min heap as min element will rise to top and will be poped
        priority_queue<int, vector<int>,greater<int>> pq;
        for(auto& num:nums){
            pq.push(num);
            if(pq.size()>k) pq.pop();
        }
        return pq.top();
    }
};