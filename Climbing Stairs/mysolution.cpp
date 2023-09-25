class Solution {
public:
    int climbStairs(int n) {
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        
        vector<int> L(n,0);
        
        L[0]=1;
        L[1]=2;
        
        for(int i=2;i<n;i++)
        {
            L[i]=L[i-1]+L[i-2];
        }
        
        return L[n-1];
    }
};