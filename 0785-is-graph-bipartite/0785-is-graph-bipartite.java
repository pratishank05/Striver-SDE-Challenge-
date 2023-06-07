class Solution {

    private boolean check(int start,int V, ArrayList<ArrayList<Integer>> adj,int color[]){
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        int n=graph.length;
        int m=graph[0].length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
               adj.get(i).add(graph[i][j]);
            }
        }
        
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i]==-1){
                if(check(i,n,adj,color)==false)return false;
            }
        }
        return true;
    }
}