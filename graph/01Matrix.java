https://leetcode.com/problems/01-matrix/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0) return mat;
        int[] dir = {0,1,0,-1,0};
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1*mat[i][j];
                }
            }
        }
        
        while(q.size()>0){
            int[] top = q.poll();
            for(int i=0;i<4;i++){
                int rn = top[0]+dir[i];
                int cn = top[1]+dir[i+1];
                if(rn>=0 && rn<m && cn>=0 && cn<n && mat[rn][cn]<0){
                    mat[rn][cn]=mat[top[0]][top[1]]+1;
                    q.offer(new int[]{rn,cn});
                }
            }
        }
        
        return mat;
    }
}