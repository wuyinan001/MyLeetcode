class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int n=colors.size();
        
        int i=0,j=0;
        
        int maxtime=0, sum1=0, ans=0;
        
        while(j<n)
        {
            if(colors[j]!=colors[i])
            {
                ans+=(sum1-maxtime);
                sum1=0;
                maxtime=0;
                i=j;
            }
            
            sum1+=neededTime[j];
            maxtime=max(maxtime,neededTime[j]);
            j++;
        }
        
        if(i!=j)
        {
            ans+=(sum1-maxtime);
        }
        
        return ans;
    }
};