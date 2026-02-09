//https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/
/*
Intuition: 
---------

    * Let's try, to to make some observations:

    Input: nums = [3,1,6,8], queries = [1,5]
    Output: [14, 10]
    
    queires[0] = 1, ans = 14, 
    answer 14 can be easily compute as (total_sum_of_nums - nums_size * queries[0]) -> (18 - 4 * 1) -> 14

    queries[1] = 5, ans = 10, 
    but the above point is NOT always valid for all "i"th queries.
    
    For example here, (18 - 4 * 5) -> -2 
    
    #1 -ve is indicating that we've to add some more items on couple of indices.
    
    #2 -ve answer also indicating that some of the elements in "nums" are lesser than "queries[i]"
    
    #3 Also total_sum of array(nums) doesn't give us the information about the elements that
        are at different indices in "nums" array.
        
    #4 From [3, 1, 6, 8], queries[1] = 5, this thought is came from Obs#2
    
            Q: all the elements that are smaller(or equal can be added here)
                    than (5 : current ith query) would contribute how much in our final answer?
                    
            A: (count_of_elements * queries[i] - sum_of_all_those_elements)
            
                for example, here for the 1st query:
                
                cont_of_elements = 2 -> {1, 3} -> [1 & 3 are smaller than 5]
                
                contribution = (2 * 5 - (1 + 3)) = 6
                
                
                Similarly, total contribution of elements in our final answer from
                elements larger than queries[i] can be given as:
                
                contribution = (sum_of_all_such_elements - count_of_such_elements * queries[i])
                
                contribution = ((6 + 8) - (2 * 5)) -> (14 - 10) -> 4
                
                
                now add the contributions = (6 + 4) -> 10 [final answer for 1st query]
                
                
            * Counting part can be efficiently computed using "Binary Search" and for getting a sum of elements
                for any sub-array can be easily computed in O(1) with the help of "prefix-sum" array.
                    - But "Binary Search" can be applied only in monotonic data, hence sorting required.
                
        
        +++ Now, I got the approach. Excellent man :).
*/
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int N = nums.length;
        long[] prefixSum = new long[N];
        
        //create the prefix sum array 
        for(int i = 0; i < N; i += 1) {
            if(i == 0) prefixSum[i] = nums[i];
            else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
                
        List<Long> answer = new ArrayList<>();
        
        for(int i = 0; i < queries.length; i += 1) {
            int queryEle = queries[i];
            //get the position where the query element is/will be in the array
            int idx = upperBound(nums, queryEle);
            //if the query element is > array size - all will have to be moved up 
            if(idx == N) {
                answer.add(((N * 1L * queryEle) - prefixSum[N - 1]));
            } else {
                //from the right side sum reduce the QE for each element 
                long contri1 = (prefixSum[N - 1] - prefixSum[idx] + nums[idx] ) - (N - idx) * 1L * queryEle; // for larger > queries[i]
                long contri2 = 0;
                if(idx != 0) 
                    contri2 = (idx * 1L * queryEle) - (prefixSum[idx - 1]); // for smaller <= queries[i]
                answer.add((contri1 + contri2));
            }
        }
        
        return answer;
    }
    
    // returns the first index (idx) such that nums[idx] > target
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}