class Solution {
public:
    string removeKdigits(string num, int k) {
        int len = num.size();
        stack<char> s;
        for(char c:num){
            //pop the stack till k>0 and a number greater than current is present in stack
            while(!s.empty() && s.top()>c && k>0){
                s.pop(); k--;
            }
            
            //if the stack is empty and the number to be inserted is 0 then we just skip it.
            if(s.empty() && c=='0'){
                continue;
            }else{
                s.push(c);
            }
        }
        while(!s.empty() && k>0){
            s.pop();k--;
        }
        if(s.empty()) return "0";
        while(!s.empty()){
            num[len-1] = s.top();
            s.pop();
            len--;
        }
        return num.substr(len);
    }
};