class Solution {
    public String addStrings(String num1, String num2) {
        
        
        int l1 = num1.length();
        int l2 = num2.length();
        String ans = "";
        
        
        l1--;l2--;
        int carry = 0;
        while(l1>=0 || l2>=0 || carry>0){
            int sum;
            int x = l1>=0? num1.charAt(l1)-'0' : 0;
            int y = l2>=0? num2.charAt(l2)-'0' : 0;
            
            sum = x+y+carry;
            
            ans = sum%10+ans;
            carry = sum/10;
            l1--;
            l2--;
        }
        
        return ans;
    }
}