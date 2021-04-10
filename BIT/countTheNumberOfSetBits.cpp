#include<bits/stdc++.h>
using namespace std;
//efficient program to count the number of set bits aka Kerninghams algo
int main(){
    int n;
    cin>>n;
    int count=0;
    while(n!=0){
        //find the rightmost set bit
        int rmsb = n & -n;
        //subtract rmsb from the number
        n = n-rmsb;
        //increase the counter
        count++;
    }
    cout<<count<<endl;
    return 0;
}