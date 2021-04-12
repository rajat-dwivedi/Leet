#include<bits/stdc++.h>
using namespace std;
//method 2 to get the righmost set bit of a number
int main(){

    int n;
    cin>>n;
    
    //finding the rightmost set bit
    int rmsb =1;

    while((n&rmsb)==0){
        rmsb = rmsb<<1;
    }
    
    //this will be the rightmost set bit
    cout<<rmsb<<endl;
    return 0;
}