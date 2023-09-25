class Solution {
    
    int V;
    List<Integer>[] adj;
    boolean[] visited;
    int cmp;
    
    private void dfs(int u)
    {
        visited[u]=true;
        for(int v:adj[u])
            if(!visited[v])
                dfs(v);
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        V=isConnected.length;
        
        adj=new List[V];
        
        for(int i=0;i<V;i++)
            adj[i]=new ArrayList();
        
        for(int i=0;i<V;i++)
            for(int j=i+1;j<V;j++)
                if(isConnected[i][j]==1)
                {
                    adj[i].add(j);
                    adj[j].add(i);
                }
        
        visited=new boolean[V];
        cmp=0;
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                cmp++;
                dfs(i);
            }
        }
        
        return cmp;
    }
}