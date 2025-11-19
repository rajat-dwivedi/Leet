class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!map.containsKey(u)){
                map.put(u, new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v, new ArrayList<>());
            }
            map.get(u).add(v);
            map.get(v).add(u);
        }

        q.offer(source);
        visited.add(source);

        while(q.size()>0){
            Integer temp = q.poll();
            if(temp==destination){
                return true;
            }
            List<Integer> around = map.getOrDefault(temp, new ArrayList<>());
            for(Integer ar: around){
                if(!visited.contains(ar)){
                    visited.add(ar);
                    q.offer(ar);
                }
            }
        }
        return false;
    }
}