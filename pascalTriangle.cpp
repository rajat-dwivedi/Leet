class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        int n = numRows;
        vector<vector<int>> res(n);
        for(int i=0;i<n;i++){
            res[i].resize(i+1);
            for(int j=0;j<=i;j++){
                if(j==i || j==0){
                    res[i][j] =1;
                }else{
                    res[i][j] = res[i-1][j-1]+res[i-1][j];
                }
            }
        }
        return res;
    }
};