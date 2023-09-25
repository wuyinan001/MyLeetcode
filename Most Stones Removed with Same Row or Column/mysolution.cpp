class UF
{
public:
    int cmp;
    int V;
    vector<int> pi;
    vector<int> rank;
    
    UF(int n)
    {
        V=n;
        cmp=n;
        for(int i=0;i<n;i++)
        {
            pi.push_back(i);
            rank.push_back(0);
        }
    }
    
    int find(int x)
    {
        int rx=x;
        while(pi[rx]!=rx)
            rx=pi[rx];
        pi[x]=rx;
        return rx;
    }
    
    bool isConnected(int x, int y)
    {
        return find(x)==find(y);
    }
    
    void connect(int x, int y)
    {
        if(isConnected(x,y))
            return;
        int rx=find(x), ry=find(y);
        
        if(rank[rx]>rank[ry])
            pi[ry]=rx;
        else
        {
            pi[rx]=ry;
            if(rank[rx]==rank[ry])
                rank[ry]++;
        }
        
        cmp--;
    }
};

class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        int n=stones.size();
        UF uf(n);
        
        cout<<uf.cmp<<endl;
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                    uf.connect(i,j);
            }
        }
        
        return n-uf.cmp;
    }
};