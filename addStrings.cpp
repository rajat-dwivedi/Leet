class Solution {
public:
    string addStrings(string num1, string num2) {
        string res = "";
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int carry = 0;
        while(l1>=0 || l2>=0 || carry>0){
            int x = l1>=0?num1[l1]-'0':0;
            int y = l2>=0?num2[l2]-'0':0;
            int sum = x+y+carry;
            char num = '0'+(sum%10);
            res = num+res;
            carry = sum/10;
            l1--,l2--;
            
        }
        return res;
    }
};