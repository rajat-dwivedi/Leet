//https://leetcode.com/problems/find-the-duplicate-number/
// m0 - check for each element - O(N^2) TLE
class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]==nums[j]) return nums[i];
            }
        }
        return -1;
    }
}

//m1 - memory O(N) time and O(N)space complexity
class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            if(set.add(nums[i])==false){
                return nums[i];
            }
        }
        return -1;
    }
}

//m2 - binary search 

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

//m3 - bitmask
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int duplicate = 0;
        for(int i=0;i<32;i++){
            int mask = 1<<i;
            int baseCount=0, numCount=0;
            for(int j=0;j<=n;j++){
                if((j&mask)>0) baseCount++;
                if((nums[j]&mask)>0)numCount++;
            }
            if(numCount>baseCount){
                duplicate|=mask;
            }
        }
        return duplicate;
    }
}