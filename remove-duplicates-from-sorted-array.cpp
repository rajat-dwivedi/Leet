#include<bits/stdc++.h>
using namespace std;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/


int main(){
    int arr[] = {0,0,1,1,1,2,2,3,3,4};
    int n = sizeof(arr)/sizeof(arr[0]);
    //we use the two pointer approach
    int start = 0, end = start+1;
    if(n==0)
        return n;
    for( ; end<n;end++){
        //if the two pointers have same value then continue the end pointer
        if(arr[start]==arr[end])
            continue;
            //else place the element at the end pointer into the start position and increment start by one
        else
            arr[++start] = arr[end];
    }


    //printing the length of the new array with unique elements.
    cout<<start+1<<endl;
    for(int i =0;i <start+1;i++)
        cout<<arr[i]<<" ";
    return 0;
}