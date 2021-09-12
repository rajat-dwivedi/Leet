class Solution {
public:
    int maximumSwap(int num) {
        string n = to_string(num);
        int maxidx = -1, maxnum=-1,leftidx=-1,rightidx=-1;
        
        for(int i=n.length()-1;i>=0;i--){
            if(n[i]>maxnum){
                maxnum = n[i];
                maxidx = i;
                continue;
            }else{
                if(n[i]<maxnum){
                    leftidx = i;
                    rightidx = maxidx;
                }
            }
        }
        if(leftidx==-1) return num;
        swap(n[leftidx],n[rightidx]);
        int res = stoi(n);
        return res;
    }
};