// https://leetcode.com/problems/is-graph-bipartite/
//for a graph to be bipartite all the nodes of graph should be painted using 2 color such that no two adjacent node have the same color. basically graph having odd length cycle cannot be bipartite
//sc - O(N+E)
class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        //nodes in graph
        int num = graph.size();
        queue<int> q;
        
        //initial all are colored -1 ie unvisited
        vector<int> color(num, -1);
        
        //check for all the nodes if they are colored or not
        for(int i=0;i<num;i++){
            //if not colored then
            if(color[i]==-1){
                color[i] = 1;
                q.push(i);
                //doing bfs on all adjacent nodes of i
                while(!q.empty()){
                    int temp = q.front();
                    q.pop();
                    
                    //going through all adjacent nodes of i in list
                    for(auto next : graph[temp]){
                        //if adjacent node is not colored yet, color it to opposite of present node and push it to queue
                        if(color[next]==-1){
                            color[next] = 1-color[temp];
                            q.push(next);
                            //if adjacent node is already colored in the color of present node then it shows graph cannot be bipartite
                        }else if(color[next]==color[temp]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};