// https://leetcode.com/problems/unique-paths-ii/
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        int t[m][n];
        bool flag = false;
        
        //populate the first row
        for(int i=0;i<n;i++){
            
            //if any obstacle all the grids after that are also unaccessable
            if(flag||obstacleGrid[0][i]==1){
                flag = true;
                t[0][i] = 0;
            }else{
                t[0][i] = 1;
            }
        }
        
        //populate the first column
        flag = false;
        for(int j=0;j<m;j++){
            //if any obstacle all the grids after that are also unaccessable
            if(flag||obstacleGrid[j][0]==1){
                flag = true;
                t[j][0] = 0;
            }else{
                t[j][0] = 1;
            }
        }
        
        //populate the answer grid
        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                //if any obstacle than that place cannot be reached in any way
                if(obstacleGrid[j][i]==1){
                    t[j][i] = 0;
                }else
                    t[j][i] = t[j-1][i]+t[j][i-1];
            }
        }
        
        //return the total number of ways to reach at bottom right corner
        return t[m-1][n-1];
    }
};