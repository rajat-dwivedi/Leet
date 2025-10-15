class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int fresh = 0, rot = 0, ans=0;
        Queue<int[]> q = new LinkedList<>();
        int[] dir = {0,1,0,-1,0};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(fresh ==0) return 0;
        while(q.size()>0){
            if(fresh==rot) break;
            int len = q.size();
            for(int k=0;k<len;k++){
                int[] top = q.poll();
                for(int i=0;i<4;i++){
                    int x = top[0]+dir[i];
                    int y = top[1]+dir[i+1];
                    if(x<0||x>=row || y<0 || y>=col) continue;
                    if(grid[x][y]==1){
                        rot++;
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                    }
                }
            }
            ans++;
        }
        if(rot==fresh) return ans;
        else return -1;
    }
}