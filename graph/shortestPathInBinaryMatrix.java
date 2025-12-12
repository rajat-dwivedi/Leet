class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        q.add(new int[]{0, 0});
        int count =0;
        grid[0][0] = 1;
        int[] row = {0,0,1,1,1,-1,-1,-1};
        int[] col = {-1,1,0,1,-1,0,1,-1};
                while(!q.isEmpty()){
                    count++;
                    int size=q.size();
                    while(size-->0){
                        int[] A=q.poll();
                        int r=A[0];
                        int c=A[1];
                        for(int i=0; i<8; i++){
                            int r1 = r+row[i];
                            int c1 = c+col[i];
                           
                            if(r1>=0 && c1>=0 && r1<n && c1<n && grid[r1][c1] == 0){
                                if(r1==n-1 && c1==n-1) return count+1;
                                q.add(new int[] {r1,c1});
                                grid[r1][c1] = 1;
                            }
                        }
                    }
                }

        // return -1;
        return grid[n-1][n-1]==1 ? count : -1;
    }
}