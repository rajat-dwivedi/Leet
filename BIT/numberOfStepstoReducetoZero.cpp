//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {
public:
    int numberOfSteps(int num) {
        int steps = 0;
        if(num==0)
            return steps;
        while(num){
            if(num%2){
                num-=1;
            }
            else{
                num=num>>1;
            }
            steps++;
        }
        return steps;
    }
};