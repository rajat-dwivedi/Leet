//https://leetcode.com/problems/complement-of-base-10-integer/
//1009complementOfBase10Integer

class Solution {
 public:
  int bitwiseComplement(int N) {
    int mask = 1;

    while (mask < N)
      mask = (mask << 1) + 1;

    return mask ^ N;
  }
};