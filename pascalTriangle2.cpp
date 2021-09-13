class Solution {
public:
    vector<int> getRow(int rowIndex) {
        long val = 1;
        vector<int> res;
        for(int j=0;j<=rowIndex;j++){
            res.push_back((int)val);
            val = (val * (rowIndex-j))/(j+1);
        }
        return res;
    }
};