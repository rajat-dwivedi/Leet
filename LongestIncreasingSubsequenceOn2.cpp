#include<bits/stdc++.h>
using namespace std;
//O(n*n) time complexity approach of solving LIS problem

int LIS(int arr[], int n){

    //creating an array to store lis for arr[i]. having lis ending at i and having arr[i] in lis
    int t[n];
    if(n==0)
    return 0;

    //lis for every single element is 1
    // for(int i=0;i<n;i++)
    //     t[i] = 1;
    
    t[0] = 1;
    //for every element in the array we compare from start till that point in array
    for(int i=1;i<n;i++){
        //storing the largest lis[k] for 0<k<i
        int max = 0;

        for(int j=0;j<i;j++){
            //if arr[j] is smaller than arr[i] and the 
            if(arr[j]<arr[i] && t[j]>max){
                max = t[j];
            }
        }
        //now we just add arr[i] in the largest lis till arr[i]
        t[i] = max+1;
    }
  
  //code to print the elements of LIS
    // int l = 0;
    // for(int i=0;i<n;i++){
    //     if(t[i]>l){
    //         cout<<arr[i]<<" ";
    //         l = t[i];
    //     }
    // }
    // cout<<endl;

    return *max_element(t,t+n);
}

int main(){
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    //answer 6 {10, 22, 33, 50, 60, 80};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout<<LIS(arr,n)<<endl;
    return 0;
}