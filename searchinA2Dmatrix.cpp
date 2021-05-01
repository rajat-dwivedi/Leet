//https://leetcode.com/problems/search-a-2d-matrix/
//converting from mid to row(i) and column(j) 
//row will be mid/total number of colums in matrix
//column will be mid%total number of columns in matrix
class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        
        
        //finding the number of rows
        int n = matrix.size();
        //finding the number of columns
        int m = matrix[0].size();
        //doing binary search in the martix as the matrix is sorted
        int l = 0, r = m * n - 1;
        while (l <= r){
            int mid = l+(r-l)/2;
            if (matrix[mid / m][mid % m]== target)
                return true;
            else if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid-1;
        }
        return false;
    }
};