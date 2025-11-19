class Solution {
    public boolean dfs(int node, int[][] graph, int[] vis, int[] pathvis, int[] safe){
        //checking if the node is a part of a cycle with the help of dfs
        //mark node as visited
        vis[node] = 1;
        //mark pathvis
        pathvis[node] = 1;
        //get all the adjacent nodes of the current node
        int[] adj = graph[node];
        //traverse all the adjacent nodes of the current node
        for(int i=0;i<adj.length;i++){
            //if adjacent node is not yet visited then do dfs to check if it has cycle
            if(vis[adj[i]]==0){
                //if cycle return true
                if(dfs(adj[i], graph, vis, pathvis, safe)==true)
                    return true;
            }else{
                //if the node is already visited and is also in current path then return true has cycle
                if(pathvis[adj[i]]==1)
                    return true;
            }
        }
        //no cycle found neither node points to any cycle so mark is safe
        safe[node] = 1;
        //unmark from visited path 
        pathvis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        if(graph==null || graph.length==0) return ans;
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] safe = new int[n];

        //doing dfs traversal on all the nodes
        for(int i=0;i<n;i++){
            //if the node is not yet visited then do dfs on that node
            if(vis[i]==0){
                dfs(i, graph, vis, pathvis, safe);
            }
        }
        for(int i=0;i<n;i++){
            if(safe[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}

//bfs
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int len = graph.length;
        int[] ind = new int[len];
        for(int i=0;i<graph.length;i++){
            for(int n: graph[i]){
                if(!map.containsKey(n)){
                    map.put(n,new ArrayList<>());
                }
                map.get(n).add(i);
                ind[i]++;
            }
        }

        for(int i=0;i<len;i++){
            if(ind[i]==0){
                q.offer(i);
            }
        }

        while(q.size()>0){
            Integer top = q.poll();
            res.add(top);
            for(Integer temp: map.getOrDefault(top, new ArrayList<Integer>())){
                ind[temp]--;
                if(ind[temp]==0) q.offer(temp);
            }
        }

        Collections.sort(res);
        return res;
    }
}