// https://leetcode.com/problems/combinations/
class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        if (n < 1 || k < 1 || k > n) return result;
        vector<int> v;
        collect(n, k, 0, v, result);
        return result;
    }
    void collect(int n, int k, int i, vector<int> &v, vector<vector<int>> &ret) {
        if (v.size() == k) {
            ret.push_back(v);
            return;
        }
        while (i < n) {
            v.push_back(i + 1);
            collect(n, k, i + 1, v, ret);
            v.pop_back();
            i++;
        }
    }
};
