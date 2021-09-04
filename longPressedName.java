class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length(); 
        int m = typed.length();
        
        if(n>m)
            return false;
        int i=0, j=0;
        while(i<n && j<m){
            if(name.charAt(i)==typed.charAt(j))
            {
                i++; j++;
            }else if(i>0 && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        
        while(j<m){
            if(typed.charAt(j)!=name.charAt(n-1)) return false;
            j++;
        }
        
        return i<n?false:true;
    }
}