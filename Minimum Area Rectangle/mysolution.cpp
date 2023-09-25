class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        set<pair<int,int>> set;
        
        for(auto v:points)
        {
            set.insert({v[0],v[1]});
        }
        
        int ans=INT_MAX, n=points.size();
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(points[i][0]!=points[j][0]&&points[i][1]!=points[j][1]\
                  &&set.find({points[i][0],points[j][1]})!=set.end()\
                  &&set.find({points[j][0],points[i][1]})!=set.end())
                {
                    ans=min(ans,abs(points[i][0]-points[j][0])*abs(points[i][1]-points[j][1]));
                }
            }
        }
        
        return ans==INT_MAX? 0 : ans;
    }
};