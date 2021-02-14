class Solution {
    void solve(vector<vector<int>>& res, vector<int>& temp, vector<int>& candidates, int begin, int target){
        if(target==0){
            res.push_back(temp);
            return;
        }
        for(int i=begin; i<candidates.size() && candidates[i]<=target;i++){
            temp.push_back(candidates[i]);
            solve(res, temp, candidates, i, target-candidates[i]);
            temp.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> temp;
        vector<vector<int>>res;
        sort(candidates.begin(), candidates.end());
        solve(res, temp, candidates, 0, target);
        return res;
    }
};