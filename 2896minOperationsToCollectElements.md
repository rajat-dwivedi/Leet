//https://leetcode.com/problems/minimum-operations-to-collect-elements/
//2896minOperationsToCollectElements
//m0 - using set
class Solution {
public int minOperations(List<Integer> nums, int k) {
HashSet<Integer> set = new HashSet<>();
int count=0;
for(int i=nums.size()-1;i>=0;i--){
count++;
if(nums.get(i)>k) continue;
set.add(nums.get(i));
if(set.size()==k) return count;
}
return -1;
}
}

//m1 - bitmasking - corner case of long
class Solution {
public int minOperations(List<Integer> nums, int k) {
// Use 1L and long to handle k > 30
long target = (1L << k) - 1;
long temp = 0;
int count = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            count++;
            int num = nums.get(i);

            // We only care about numbers between 1 and k
            if (num >= 1 && num <= k) {
                // Use 1L here as well for the shift
                temp |= (1L << (num - 1));
            }

            if (temp == target) return count;
        }
        return -1;
    }

}
