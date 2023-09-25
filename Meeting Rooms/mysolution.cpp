class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int n=intervals.size();
        
        for(int i=0;i<n-1;i++)
        {
            if(intervals[i][1]>intervals[i+1][0])
                return false;
        }
        return true;
    }
};