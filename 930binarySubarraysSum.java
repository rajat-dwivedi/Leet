//m0
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int ans = 0, sum = 0;
        for(int i=0;i<len;i++){
            sum = 0;
            for(int j=i;j<len;j++){
                sum+=nums[j];
                if(sum==goal) ans++;
            }
        }
        return ans;
    }
}
//m1
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }

    public int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            //here to res we add the number of subarrays starting at j(to the right)
            //and going till i(to the left), that have sum = k
            res += j - i + 1;
        }
        System.out.println(res);
        return res;
    }
}

//prefix sum approach
class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int len = nums.length, tsum = 0,res=0;
        //hashmap to store the sum and count of how many times that sum happens
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num: nums){
            tsum+= num;
            if(tsum>=k){
                if(map.containsKey(tsum-k)){
                    res+=map.get(tsum-k);
                }
            }
            map.put(tsum,map.getOrDefault(tsum, 0)+1);
        }
        return res;
    }
}