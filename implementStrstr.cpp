// https://leetcode.com/problems/implement-strstr/
//if we dont do lcs and instead do two loops within each other the time complexity will be O(mn)
//using kmp we decrease the time complecity to O(m+n)
class Solution {
private:
    //this takes O(n) time
    void compute(int* lps, string needle, int n){
        lps[0]=0;
        int i=1,len=0;
        while(i<n){
            if(needle[i]==needle[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
public:
    int strStr(string haystack, string needle) {
        int n = needle.length();
        int m = haystack.length();
        if(n==0)
            return 0;
        if(m==0)
            return -1;
        
        int lps[n];
        compute(lps,needle,n);
        // for(int x: lps){
        //     cout<<x<<" ";
        // }
        int i=0,j=0;
        //this process takes O(m) time
        //thus the total time is O(m+n)
        while(i<m){
            if(haystack[i]==needle[j]){
                i++;j++;
            }
            if(j==n){return i-j;}
            else if(i<m && haystack[i]!=needle[j]){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    
};