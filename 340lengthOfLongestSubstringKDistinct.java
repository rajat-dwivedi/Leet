//m0
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int st =0,ans=0;
        for(int e=0;e<len;e++){
            char ch = s.charAt(e);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            while(map.size()>k){
                map.put(s.charAt(st),map.get(s.charAt(st))-1);
                if(map.get(s.charAt(st))==0)map.remove(s.charAt(st));
                st++;
            }
            ans = Math.max(ans,e-st+1);
        }
        return ans;
    }
}

//m1
public class Solution {
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] count = new int[256];
    // there are 256 ASCII characters in the world
    
    int i = 0;  // i will be behind j
    int num = 0;
    int res = 0;
    
    for (int j = 0; j < s.length(); j++) {
        if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
            num++;
        }
        while (num > k && i < s.length()) {     // sliding window
            count[s.charAt(i)]--;
            if (count[s.charAt(i)] == 0){ 
                num--;
            }
            i++;
        }
        res = Math.max(res, j - i + 1);
    }
    return res;
}
}