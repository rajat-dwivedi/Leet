// https://leetcode.com/problems/count-vowel-substrings-of-a-string/
//m1 - brute force - O(n3)
class Solution {
    private boolean check(String s){
        // if(s.legnth()<5) return false;
        int a=0,e=0,i=0,o=0,u=0;
        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(ch=='a')a++;
            else if(ch=='e')e++;
            else if(ch=='i')i++;
            else if(ch=='o')o++;
            else if(ch=='u')u++;
            else return false;
        }
        if(a>0 && e>0 && i>0 && o>0 && u>0) return true;
        else return false;
    }
    public int countVowelSubstrings(String word) {
        int ans = 0, len = word.length();
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(j-i+1<5) continue;
                if(check(word.substring(i,j+1))){
                    ans++;
                }
            }
        }
        return ans;
    }
}
//m2 - o(n2)
class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0, len = word.length();
        for(int i=0;i<len;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<len;j++){
                // if(j-i+1<5) continue;
                char ch = word.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o'|| ch=='u'){
                    set.add(ch);
                    if(set.size()==5) ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}