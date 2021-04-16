// https://leetcode.com/problems/unique-paths/
class Solution {
public:
    int uniquePaths(int m, int n) {
        int t[m+1][n+1];
        //we are assuming the star is moving to the robot
        //there will only be one path for all blocks in the first row that is to the left 
        //similary for all blocks in the first column
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    t[i][j] = 1;
                }else{
                    //number of ways from current block = 
                    //number of ways from above block + number of ways from the left block
                    t[i][j] = t[i-1][j]+t[i][j-1];
                }
            }
        }
        return t[m-1][n-1];
    }
};