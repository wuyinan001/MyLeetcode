class Compare
{
public:
    map<char,int> postOrder;
    Compare(map<char,int>& postOrder)
    {
        this->postOrder=postOrder;
    }
    
    bool operator()(char c1, char c2)
    {
        return postOrder[c1]>postOrder[c2];
    }
};

class Solution {
public:
    map<char,vector<char>> adj;
    map<char,int> postOrder;
    map<char,bool> visited;
    int clock=0;
    
    void dfs(char u)
    {
        visited[u]=true;
        clock++;
        for(char v:adj[u])
        {
            if(!visited[v])
                dfs(v);
        }
        clock++;
        postOrder[u]=clock;
    }
    
    string alienOrder(vector<string>& words) {
        for(auto w:words)
        {
            for(auto c:w)
            {
                if(adj.find(c)==adj.end())
                {
                    adj[c]={};
                    postOrder[c]=-1;
                    visited[c]=false;
                }  
            }
        }
        
        int n=words.size();
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int n1=words[i].size(), n2=words[j].size();
                if(n1>n2&&words[j]==words[i].substr(0,n2))
                    return "";
                
                for(int k=0;k<min(n1,n2);k++)
                {
                    if(words[i][k]!=words[j][k])
                    {
                        adj[words[i][k]].push_back(words[j][k]);
                        break;
                    }
                }
            }
        }
        
        for(auto i:adj)
        {
            if(!visited[i.first])
            {
                dfs(i.first);
            }
        }
        
        for(auto i:postOrder)
        {
            for(char v:adj[i.first])
            {
                if(postOrder[i.first]<=postOrder[v])
                    return "";
            }
        }
        
        vector<char> list;
        
        for(auto i:postOrder)
            list.push_back(i.first);
        
        sort(list.begin(),list.end(),Compare(postOrder));
        
        return string(list.begin(),list.end());
    }
};