//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int start = 0, end = letters.size()-1,mid,res=-1;
        if(target >=letters.back())
            return letters.front();
        while(start<=end){
            mid = start + (end-start)/2;
            if(letters[mid]>target){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return letters[res];
    }
};