//https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
//1784checkIfBinaryStringHasOneSegmentOfOnes

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenZero = false;

        for(char c : s.toCharArray()) {
            if(c == '0') {
                seenZero = true;
            } else if(seenZero) {
                return false;
            }
        }

        return true;
    }
}