class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<int> P(n,0);
        int ans=0;
        
        for(int i=1;i<n;i++)
        {
            P[i]=max(0,P[i-1]+prices[i]-prices[i-1]);
            ans=max(ans,P[i]);
        }
        
        return ans;
    }
};