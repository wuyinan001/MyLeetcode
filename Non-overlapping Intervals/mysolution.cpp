class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int keep=1, n=intervals.size();
        
        sort(intervals.begin(),intervals.end());
        
        vector<int> prev=intervals[0];
        
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]>=prev[1])
            {
                keep++;
                prev=intervals[i];
            }
            else if(intervals[i][1]<=prev[1])
            {
                prev=intervals[i];
            }
        }
        
        return n-keep;
    }
};