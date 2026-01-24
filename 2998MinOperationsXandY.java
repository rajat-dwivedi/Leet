//2998https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y>=x) return y-x;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[10001];
        Arrays.fill(visited, 0);
        
        q.offer(x);
        if (x == y) {
            return 0;
        }
        
        int ans = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                int f = q.poll();
                
                if (f > 10000 || f <= 0) {
                    continue;
                }
                
                if (f == y) {
                    return ans;
                }
                
                if (f % 11 == 0 && visited[f / 11] == 0) {
                    visited[f / 11] = 1;
                    q.offer(f / 11);
                }
                
                if (f % 5 == 0 && visited[f / 5] == 0) {
                    visited[f / 5] = 1;
                    q.offer(f / 5);
                }
                
                if (f - 1 >= 0 && visited[f - 1] == 0) {
                    visited[f - 1] = 1;
                    q.offer(f - 1);
                }
                
                if (f + 1 <= 10000 && visited[f + 1] == 0) {
                    visited[f + 1] = 1;
                    q.offer(f + 1);
                }
            }
            ans++;
        }
        return ans;
    }
}