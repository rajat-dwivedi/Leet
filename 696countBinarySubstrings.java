//https://leetcode.com/problems/count-binary-substrings/
//countBinarySubstrings
//m1 - O(N)
class Solution {
    public int countBinarySubstrings(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
		//we found a group 
            else {
		//number of substrings in the group that satisfiy the condition 
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }
} 

