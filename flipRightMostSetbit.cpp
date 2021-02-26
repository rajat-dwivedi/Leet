#include <bits/stdc++.h> 
using namespace std; 

// unsets the rightmost set bit 
// of n and returns the result 
// Let the input number be n. n-1 would have all the bits flipped after the rightmost set bit (including the set bit). So, doing n&(n-1) would give us the required result.
// example
// 12 = 1100
// 11 = 1011
int fun(unsigned int n) 
{ 
	return n & (n - 1); 
} 

// Driver Code 
int main() 
{ 
	int n = 7; 
	cout<<"The number after unsetting the"; 
	cout<<" rightmost set bit "<<fun(n); 
	return 0; 
} 
