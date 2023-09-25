class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        priority_queue<int, vector<int>, greater<int>> pq;
        
        int n=intervals.size();
        sort(intervals.begin(),intervals.end());
        int ans=0;
        
        for(auto v:intervals)
        {
            while(!pq.empty() and pq.top()<=v[0])
            {
                pq.pop();
            }
            
            pq.push(v[1]);
            
            ans=max(ans,int(pq.size()));
        }
        
        return ans;
    }
};