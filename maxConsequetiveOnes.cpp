#include<bits/stdc++.h>
using namespace std;
//https://leetcode.com/problems/max-consecutive-ones/

int main(){
    int arr[] = {1,1,0,1,1,1};
    int count=0,maxi=0;
    for(auto x: arr){
        if(x==1){
            count++;
            maxi = max(count, maxi);
        }else
            count=0;
    }
    cout<<maxi<<endl;
    return 0;
}