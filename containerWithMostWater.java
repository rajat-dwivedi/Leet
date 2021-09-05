class Solution {
    public int maxArea(int[] height) {
                int water = 0, a=0, b=height.length-1;
        
        while(a<b){
            int w = b-a;
            int h = Math.min(height[a],height[b]);
            water = Math.max(water, h*w);
            
            if(height[a]<height[b])
                a++;
            else
                b--;
        }
        
        return water;
    }
}