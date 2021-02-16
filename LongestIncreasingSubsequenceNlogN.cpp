#include<bits/stdc++.h>
using namespace std;
//O(NlogN) solution approach of LIS problem
//the solution only gives the length of the lis not the sequence

void lis(int arr[], int n){
    vector<int> res;
    res.push_back(arr[0]);

    for(int i=1;i<n;i++){
        if(arr[i]>res.back()){
            res.push_back(arr[i]);
        }else{
            int ind = lower_bound(res.begin(), res.end(), arr[i])-res.begin();
            res[ind] = arr[i];
        }
    }
   
    cout<<res.size();
}

int main(){
    int arr[] = {2,5,3,7,11,8,10,13,6};
    //ans 2 3 7 8 10 13 (length = 6)
    int n = sizeof(arr)/sizeof(arr[0]);
    lis(arr,n);
    return 0;
}
