// https://leetcode.com/problems/counting-bits/
class Solution {
public:
    int count(int n){
        int bits=0;
        while(n){
            int rmsb = n & -n;
            n = n-rmsb;
            bits++;
        }
        return bits;
    }
    vector<int> countBits(int num) {
        vector<int> res;
        for(int i=0;i<=num;i++){
            // int ans = count(i);
            res.push_back(count(i));
        }
        return res;
    }
};