// The API isBadVersion is defined for you.
// bool isBadVersion(int version);
//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
class Solution {
public:
    int firstBadVersion(int n) {
        int len = n;
        int start = 0, end = n-1,prev,next,mid;
        while(start<=end){
            mid = start + (end-start)/2;
            prev = (mid-1+len)%len;
            next = (mid+1)%len;
            if(isBadVersion(mid)==false && isBadVersion(next)==true)
                break;
            else if(isBadVersion(mid)==false && isBadVersion(next)==false){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return mid+1;
    }
};