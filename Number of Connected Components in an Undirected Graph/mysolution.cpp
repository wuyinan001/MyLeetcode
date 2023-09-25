class Solution {
public:
    int cmp=0;
    vector<vector<int>> adj;
    vector<bool> visited;
    int V=0;
    
    void dfs(int u)
    {
        visited[u]=true;
        for(auto v:adj[u])
            if(!visited[v])
                dfs(v);
    }
    
    void dfs()
    {
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                cmp++;
                dfs(i);
            }
        }
    }
    
    int countComponents(int n, vector<vector<int>>& edges) {
        V=n;
        
        for(int i=0;i<n;i++)
        {
            adj.push_back({});
            visited.push_back(false);
        }
        
        for(auto edge:edges)
        {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        
        dfs();
        
        return cmp;
    }
};