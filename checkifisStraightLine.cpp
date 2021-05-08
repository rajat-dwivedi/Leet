//https://leetcode.com/problems/check-if-it-is-a-straight-line/
class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        int x1,x2,y1,y2,x,y;
        if(coordinates.size()==2)
            return true;
        x1 = coordinates[0][0];
        x2 = coordinates[1][0];
        y1 = coordinates[0][1];
        y2 = coordinates[1][1];
        // int slope = ((y2-y1)/(x2-x1));
        for(int i=2;i<coordinates.size();i++){
            x =coordinates[i][0];
            y =coordinates[i][1];
            if((y2-y)*(x1-x)!=(y1-y)*(x2-x)){return false;}
            
        }
        return true;
    }
};