//https://leetcode.com/problems/set-matrix-zeroes/
//tc O(m*n)
//sc O(1)
//using first row n first col as dummy array to mark them as 0 if any element in that row or col is 0
//then we move back from bottom right and see if that row or col has 0 in first row or col and set that element to 0

class Solution {
public:
    
    void setZeroes(vector<vector<int>>& matrix) {
        int col0 = 1, rows = matrix.size(), cols = matrix[0].size();
        
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0) col0 = 0;
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        
        //moving back from bottom right
        for(int i=rows-1; i>=0;i--){
            for(int j=cols-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }            
            if(col0 == 0) matrix[i][0] = 0;
        }
        //no need to return as matrix is passed by reference and we are doing changes in place
    }
};