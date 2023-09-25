class Graph
{
public:
    int V;
    vector<vector<int>> adj;
    vector<bool> visited;
    vector<int> postOrder;
    int clock=0;
    
    Graph(int n, vector<vector<int>>& edges)
    {
        V=n;
        for(int i=0;i<n;i++)
        {
            adj.push_back({});
            visited.push_back(false);
            postOrder.push_back(-1);
        }
        
        for(auto edge:edges)
        {
            adj[edge[0]].push_back(edge[1]);
        }
    }
    
    void dfs(int u)
    {
        visited[u]=true;
        clock++;
        for(int v:adj[u])
        {
            if(!visited[v])
                dfs(v);
        }
        clock++;
        postOrder[u]=clock;
    }
    
    void dfs()
    {
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(i);
    }
    
    bool hasCycle()
    {
        for(int i=0;i<V;i++)
        {
            for(int v:adj[i])
                if(postOrder[i]<=postOrder[v])
                    return true;
        }
        return false;
    }
};

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        Graph g=Graph(numCourses, prerequisites);
        g.dfs();
        return !g.hasCycle();
    }
};