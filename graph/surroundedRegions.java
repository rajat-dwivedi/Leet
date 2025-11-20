class Solution {
    public void bfs(char[][] board, int i, int j){
        int m = board.length,  n = board[0].length;
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!='O'){
             return;
        }
        board[i][j] = 'p';
        bfs(board, i+1, j);
        bfs(board, i-1, j);
        bfs(board, i, j+1);
        bfs(board, i, j-1);
    }
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int m = board.length,  n = board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') bfs(board, i,0);
            if(board[i][n-1]=='O') bfs(board, i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') bfs(board, 0,j);
            if(board[m-1][j]=='O') bfs(board, m-1,j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                else if(board[i][j]=='p') board[i][j]='O';
            }
        }
    }
}