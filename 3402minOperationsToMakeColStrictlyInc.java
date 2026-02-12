//https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
//3402minOperationsToMakeColStrictlyInc
class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int prev = grid[0][i];
            for(int j=1;j<m;j++){
                if(grid[j][i]<=prev){
                    ans+=prev-grid[j][i]+1;
                    prev = prev+1;
                }else{
                    prev = grid[j][i];
                }
            }
        }
        return ans;
    }
}
