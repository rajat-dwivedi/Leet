class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        for(int i=2;i*i<n+1;i++){
            if(isPrime[i]==true){
                for(int j=i+i;j<n+1;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        
        int count =0;
        
        for(int i=2;i<n;i++){
            if(isPrime[i]==true){
                count++;
            }
        }
        return count;
    }
}