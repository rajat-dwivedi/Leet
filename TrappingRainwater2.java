class Solution {
    //two pointer approach O(n) tc O(1) sc
    public int trap(int[] height) {
        int ans = 0;
        int a = 0, b = height.length-1;
        int lmax=0,rmax=0;
        
        while(a<=b){
            lmax = Math.max(lmax,height[a]);
            rmax = Math.max(rmax,height[b]);
            if(lmax<rmax){
                ans+=(lmax-height[a]);
                a++;
            }else{
                ans+=(rmax-height[b]);
                b--;
            }
        }
        return ans;
    }
}