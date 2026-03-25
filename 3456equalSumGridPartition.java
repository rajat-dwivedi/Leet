//https://leetcode.com/problems/equal-sum-grid-partition-i/
//3456equalSumGridPartition

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        long total = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int num = grid[i][j];
                rowSum[i]+=num;
                colSum[j]+=num;
                total+=num;
            }
        }

        if(total%2!=0) return false;

        long upRowSum = 0;
        for(int i=0;i<m-1;i++){
            upRowSum+=rowSum[i];
            long rem = total-upRowSum;
            if(upRowSum==rem) return true;
        }

        long leftColSum = 0;
        for(int j=0;j<n-1;j++){
            leftColSum+=colSum[j];
            long rem = total - leftColSum;
            if(leftColSum==rem) return true;
        }

        return false;
    }
}