//https://leetcode.com/problems/next-greater-element-i/
class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int n = nums2.size();
        vector<int> ans;
        stack<int> s;
        vector<int> res;
        //for the rightmost element there is no NGE hence we save -1
        
        if(n==1)
            return res;
        for(int i=n-1;i>=0;i--){
                while(!s.empty() && s.top()<nums2[i]){
                    //remove all elements smaller than present from top of stack
                    s.pop();
                }if(!s.empty()){
                    //add top stack is NGE
                    res.push_back(s.top());
                    //push current element at the top of stack
                    s.push(nums2[i]);
                }else{
                    res.push_back(-1);
                    s.push(nums2[i]);
                }
            }
        //saving an array conataining NGE of nums2[i] at res[i]
        reverse(res.begin(), res.end());
        
        unordered_map<int, int>mp;
        for(int i=0;i<n;i++){
            mp[nums2[i]] = res[i];
        }
        
        for(int i=0;i<nums1.size();i++){
            ans.push_back(mp[nums1[i]]);
        }
        return ans;
    }
    
};