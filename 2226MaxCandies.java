class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for(int candy: candies) max = Math.max(max, candy);
        int lo = 1, hi = max, ans =0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            long childs = 0;
            for(int candy:candies){
                childs+=candy/mid;
            }
            if(childs>=k){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans;
    }
}