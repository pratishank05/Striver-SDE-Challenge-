class Solution {
    private boolean dfs(int node,int[][]graph,int[]vis,int[] pathVis,int[]safe){
        vis[node]=1;
        pathVis[node]=1;
        safe[node]=0;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,graph,vis,pathVis,safe)==true)return true;
            }
            else if(pathVis[it]==1)return true;
        }
        safe[node]=1;
        pathVis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[]vis=new int[V];
        int[]pathVis=new int[V];
        int[]safe=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathVis,safe);
            }
        }
        List<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(safe[i]==1)ans.add(i);
        }
        return ans;
    }
}