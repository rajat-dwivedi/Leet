//optimized
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][m];
        return dfs(grid, n, m, 0, 0, m - 1, dp);
    }
    int dfs(int[][] grid, int n, int m, int r, int c1, int c2, Integer[][][] dp) {
        if (r == n) return 0; // Reach to bottom row
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];
        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nc1 = c1 + i, nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < m && nc2 >= 0 && nc2 < m) {
                    ans = Math.max(ans, dfs(grid, n, m, r + 1, nc1, nc2, dp));
                }
            }
        }
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = ans + cherries;
    }
}