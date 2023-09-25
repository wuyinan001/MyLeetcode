class Solution {
    
    List<Integer>[] adj;
    boolean[] visited;
    int[] count;
    int[] stdist;
    int[] ans;
    
    private void dfs(int u)
    {
        visited[u]=true;
        
        for(int v:adj[u])
        {
            if(!visited[v])
            {
                dfs(v);
                count[u]+=count[v];
                stdist[u]+=stdist[v]+count[v];
            }
        }        
    }
    
    private void dfs2(int u)
    {
        visited[u]=true;
        
        for(int v:adj[u])
        {
            if(!visited[v])
            {
                ans[v]=ans[u]+(count[0]-count[v])-count[v];
                dfs2(v);
            }
        }
    }
    
    private void print(int[] array)
    {
        for(int i:array)
            System.out.print(i+" ");
        System.out.println();
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        // count[node]: number of nodes under subtree of node including node
        count=new int[n];
        // stdist[node]: sum of distance from subnodes under subtree of input node 
        stdist=new int[n];
        adj=new List[n];
        visited=new boolean[n];
        ans=new int[n];
        
        for(int i=0;i<n;i++)
        {
            count[i]=1;
            adj[i]=new ArrayList();
        }
        
        for(int[] edge:edges)
        {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        dfs(0);
        
        //print(count);
        //print(stdist);
        
        ans[0]=stdist[0];
        
        // Reset visited
        for(int i=0;i<n;i++)
            visited[i]=false;
        
        dfs2(0);
        
        return ans;
    }
}