class Solution {
    Map<Integer, HashSet<Integer>> adj = new HashMap<>();
    int[] deg;
    public int[] bfs() {
        int[] result = new int[deg.length];
        int ind = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < deg.length; i++) {
            if(deg[i] == 0){
                q.add(i);
            }
        }
        while(q.isEmpty() == false) {
            int curr = q.poll();
            result[ind] = curr;
            ind++;
            HashSet<Integer> children = adj.get(curr);
            if(children != null) {
                for(int child: children) {
                    deg[child]--;
                    if(deg[child] == 0)
                        q.add(child);
                }  
            }

        }
        for(int i = 0; i < deg.length; i++) {
            if(deg[i] != 0)
                return new int[0];
        }
        return result;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        deg = new int[numCourses];
        for(int i = 0; i < n; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(!adj.containsKey(b)) {
                adj.put(b, new HashSet<Integer>());
            }
            adj.get(b).add(a);
            deg[a]++;
        }
        return bfs();

    }
} 