import java.util.HashMap;

class Solution {
    //This is the O(N) solution the space is also O(N)
    public int lengthOfLongestSubstring(String s) {
        int left =0, n = s.length();
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int right=0;right<n;right++){
            if(!mp.containsKey(s.charAt(right))){
                ans = Math.max(ans,(right-left+1));
                mp.put(s.charAt(right),right);
            }else{
                left = Math.max(left, mp.get(s.charAt(right))+1);
                ans = Math.max(ans,(right-left+1));
                mp.put(s.charAt(right),right);
            }
        }
        return ans;
    }
}