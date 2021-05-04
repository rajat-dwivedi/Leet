/* https://leetcode.com/problems/number-of-islands/
dfs appraoch to solve the problem*/
class Solution {
    void solve(vector<vector<char>>& grid, int i, int j, int m, int n){
        if(i>=m ||i<0 || j>=n || j<0)
            return;
        
        if(grid[i][j]=='1'){
            //make the 1 as 2 so that we dont traverse that again
            grid[i][j] = '2';
            //check for up, down, left, right
            solve(grid, i+1, j,m,n );
            solve(grid, i,j+1,m,n );
            solve(grid, i-1,j,m,n );
            solve(grid, i,j-1,m,n );
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        //to count the number of island
        int count=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    solve(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
};