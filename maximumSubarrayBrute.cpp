#include<bits/stdc++.h>
using namespace std;

//brute force implementation of maximum subarray sum problem
int main(){
    int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
    int n = sizeof(arr)/sizeof(arr[0]);
    int maxi = INT_MIN;
    for(int i=0;i<n-1;i++){
        maxi= max(arr[i],maxi);
        for(int j=i+1;j<n;j++){
            if(arr[i]+arr[j]>maxi){
                maxi = (arr[i]+arr[j]);
            }
        }
    }
    cout<<maxi<<endl;
    return 0;
}
