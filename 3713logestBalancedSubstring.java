//https://leetcode.com/problems/longest-balanced-substring-i/
//m0 - O(N^3)
class Solution {
    private boolean isbalanced(String temp){
        int[] count = new int[26];
        char[] tc = temp.toCharArray();
        int maxf = 0;
        for(int i=0;i<temp.length();i++){
            int idx = tc[i]-'a';
            count[idx]++;
            maxf = Math.max(maxf,count[tc[i]-'a']);
        }
        for(int i=0;i<26;i++){
            // System.out.print(count[i]+" ");
            if(count[i]!=0){
                if(count[i]!=maxf) return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int len = s.length(); 
        if(len==1) return 1;
        int ans = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isbalanced(s.substring(i,j+1))){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}

// O(N^2)
class Solution {
    public int longestBalanced(String s) {
        int len = s.length(), ans =0; 
        if(len==1) return 1;
        char[] ch = s.toCharArray();

        for(int i=0;i<len;i++){
            int[] cnt = new int[26];
            int uniq = 0,maxf=0;
            for(int j=i;j<len;j++){
                //if char appearing for the first time, increase unique
                if(cnt[ch[j]-'a']==0) uniq++;
                //increment the count
                cnt[ch[j]-'a']++;
                //get the maxfrequency among all chars till now
                maxf = Math.max(maxf,cnt[ch[j]-'a']);
                //the current window length
                int cur = j-i+1;
                //if all have same freq and count then it will satisfy
                if(uniq*maxf==cur && cur>ans){
                    ans = cur;
                }
            }
        }
        return ans;
    }
}

