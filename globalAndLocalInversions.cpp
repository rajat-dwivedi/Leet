// https://leetcode.com/problems/global-and-local-inversions/
class Solution {
public:
    bool isIdealPermutation(vector<int>& A) {
        int n = A.size();
        //all local inversions are global inversions but not all global inversions are local inversions thus for them to be equal there should only be local inversion. For local inversion an element at position i can be at A[i-1], A[i] or A[i+1]. thus if abs(A[i]-i)>1 that means its a global inversion and we return false.
        for(int i = 0;i<n;i++){
            if(abs(A[i]-i)>1)
                return false;
        }
        return true;
    }
};