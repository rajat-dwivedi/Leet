class Solution {
    //backtracking 
//    public int cherryPickup(int[][] grid) {
//     return Math.max(0, cherryPickup(grid, grid.length, 0, 0, 0, 0));
//   }

//   private int cherryPickup(int[][] grid, int n, int r1, int c1, int r2, int c2) {
//     // since we're only going down and to the right, no need to check for < 0
//     // if we went out of the grid or hit a thorn, discourage this path by returning Integer.MIN_VALUE
//     if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
//       return Integer.MIN_VALUE;

//     // if person 1 reached the bottom right, return what's in there (could be 1 or 0)
//     if(r1 == n - 1 && c1 == n - 1)
//       return grid[r1][c1];

//     // if person 2 reached the bottom right, return what's in there (could be 1 or 0)
//     if(r2 == n - 1 && c2 == n - 1)
//       return grid[r2][c2];

//     int cherries;
//     // if both persons standing on the same cell, don't double count and return what's in this cell (could be 1 or 0)
//     if(r1 == r2 && c1 == c2)
//       cherries = grid[r1][c1];
//     else
//       // otherwise, number of cherries collected by both of them equals the sum of what's on their cells
//       cherries = grid[r1][c1] + grid[r2][c2];

//     // since each person of the 2 person can move only to the bottom or to the right, then the total number of cherries
//     // equals the max of the following possibilities:
//     //    P1     |      P2
//     //   DOWN    |     DOWN
//     //   DOWN    |     RIGHT
//     //   RIGHT   |     DOWN
//     //   RIGHT   |     RIGHT
//     cherries += Math.max(
//         Math.max(cherryPickup(grid, n, r1 + 1, c1, r2 + 1, c2), cherryPickup(grid, n, r1 + 1, c1, r2, c2 + 1)),
//         Math.max(cherryPickup(grid, n, r1, c1 + 1, r2 + 1, c2), cherryPickup(grid, n, r1, c1 + 1, r2, c2 + 1)));

//     return cherries;
//   }

//memoized
class Solution {
     public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        Integer[][][][] dp = new Integer[n][n][n][n]; 
        
        // Two persons start from (0, 0) to (n-1, n-1)
        // They should both reach the end with the same number of steps if exsiting valid path
        return Math.max(0, cherryPickup(grid, dp, n, 0, 0, 0, 0));
    }

    private int cherryPickup(int[][] grid, Integer[][][][] dp, int n, int r1, int c1, int r2, int c2)
    {
        // since we're only going down and to the right, no need to check for < 0
        // if we went out of the grid or hit a thorn, discourage this path by returning Integer.MIN_VALUE
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        if (dp[r1][c1][r2][c2] != null)
            return dp[r1][c1][r2][c2];

        // if person 1 reached the bottom right, return what's in there (could be 1 or 0)
        if (r1 == n - 1 && c1 == n - 1)
          return grid[r1][c1];

        // if person 2 reached the bottom right, return what's in there (could be 1 or 0)
        if (r2 == n - 1 && c2 == n - 1)
          return grid[r2][c2];

        int cherries;
        
        // if both persons standing on the same cell, don't double count and return what's in this cell (could be 1 or 0)
        if(r1 == r2 && c1 == c2)
          cherries = grid[r1][c1];
        else
          // otherwise, number of cherries collected by both of them equals the sum of what's on their cells
          cherries = grid[r1][c1] + grid[r2][c2];

        // since each person of the 2 person can move only to the bottom or to the right, then the total number of cherries
        // equals the max of the following possibilities:
        //    P1     |      P2
        //   DOWN    |     DOWN
        //   DOWN    |     RIGHT
        //   RIGHT   |     DOWN
        //   RIGHT   |     RIGHT
        cherries += Math.max(
            Math.max(cherryPickup(grid, dp, n, r1 + 1, c1, r2 + 1, c2), cherryPickup(grid, dp, n, r1 + 1, c1, r2, c2 + 1)),
            Math.max(cherryPickup(grid, dp, n, r1, c1 + 1, r2 + 1, c2), cherryPickup(grid, dp, n, r1, c1 + 1, r2, c2 + 1)));
        
        dp[r1][c1][r2][c2] = cherries;

        return cherries;
    }
}
}

