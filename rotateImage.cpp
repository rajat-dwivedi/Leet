class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        //first do a reverse of the matrix
        /* 
        1 2 3    7 8 9
        4 5 6 -> 4 5 6
        7 8 9    1 2 3
        */
        reverse(matrix.begin(), matrix.end());
        //then do the transpose of the reversed matrix
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }
};