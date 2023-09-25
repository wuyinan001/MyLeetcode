class Solution {
public:
    void print(vector<vector<int>>& intervals)
    {
        cout<<"print intervals:"<<endl;
        for(vector<int> v:intervals)
        {
            for(int i:v)
            {
                cout<<i<<" ";
            }
            cout<<endl;
        }
    }
    
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> ans;
        bool inserted=false;
        
        int n=intervals.size();
        
        for(int i=0;i<n;i++)
        {
            if(!inserted&&newInterval[0]<=intervals[i][0])
            {
                if(ans.size()==0||ans.back()[1]<newInterval[0])
                {
                    ans.push_back(newInterval);
                }
                else
                {
                    ans.back()[1]=max(ans.back()[1],newInterval[1]);
                }
                
                inserted=true;
            }
            
            if(ans.size()==0||ans.back()[1]<intervals[i][0])
            {
                ans.push_back(intervals[i]);
            }
            else
            {
                ans.back()[1]=max(ans.back()[1],intervals[i][1]);
            }
            
            //print(ans);
        }
        
        if(!inserted)
        {
            if(ans.size()==0||ans.back()[1]<newInterval[0])
            {
                ans.push_back(newInterval);
            }
            else
            {
                ans.back()[1]=max(ans.back()[1],newInterval[1]);
            }

            inserted=true;
        }
        
        return ans;
    }
};