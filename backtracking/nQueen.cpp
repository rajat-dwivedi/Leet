
//https://leetcode.com/problems/n-queens/submissions/
class Solution {
    void solve(int col, vector<int>& leftRow, vector<int>& upperd, vector<int>& lowerd, vector<vector<string>>&res, 
              vector<string>& board, int n){
        if(col == n ){
            res.push_back(board);
            return;
        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && lowerd[row+col]==0 && upperd[n-1+col-row]==0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerd[row+col] = 1;
                upperd[n-1-row+col] = 1;
                solve(col+1, leftRow, upperd, lowerd, res, board, n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerd[row+col] = 0;
                upperd[n-1-row+col] = 0;
            }
        }
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        
        vector<string> board(n);
        string s(n,'.');
        for(int i=0;i<n;i++){
            board[i] = s;
        }
        vector<int> leftRow(n,0);
        vector<int> upperd(2*n-1,0);
        vector<int> lowerd(2*n-1,0);
        solve(0,leftRow, upperd,lowerd,res, board, n);
        return res;
    }
};