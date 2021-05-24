//https://leetcode.com/problems/daily-temperatures/
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> res;
        stack<int> st;
        int n = temperatures.size();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && temperatures[st.top()]<=temperatures[i]){
                st.pop();
            }
            if(!st.empty()){
                res.push_back(st.top()-i);
                st.push(i);
            }else{
                res.push_back(0);
                st.push(i);
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};