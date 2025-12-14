//m0 - queue
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=n;i++) q.offer(i);
        while(q.size()>1){
            for(int j=1;j<k;j++){
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }
}

//m1 
class Solution {
    //tc = O(N) sc = O(N)recursive
    public int solve(int n, int k){
        if(n==1)
        return 0;
        return (solve(n-1,k)+k)%n;
    }
    public int findTheWinner(int n, int k) {
        return solve(n,k)+1;
    }
}