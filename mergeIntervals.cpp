// https://leetcode.com/problems/merge-intervals/
//tc = O(nlogn) for sorting + O(n) for traversal
//sc - O(n) in worst case if no intervals are overlapping
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size()<=1) return intervals;
        //result
        vector<vector<int>> output;
        //sort the original O(nlogn)
        sort(intervals.begin(), intervals.end());
        
        vector<int> temp = intervals[0];
        
        for(int i=1;i<intervals.size();i++){
            vector<int>pres = intervals[i];
            
            if(temp[1]>=pres[0]){
                temp[1] = max(temp[1],pres[1]);
            }else{
                output.push_back(temp);
                temp = pres;
            }
        }
        
        output.push_back(temp);
        return output;
    }
};

