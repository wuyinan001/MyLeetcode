class Solution {
    public int numTeams(int[] rating) {
        
        int ans=0;
        int leftless,leftmore,rightless,rightmore;
        
        
        int n=rating.length;
        
        for(int i=1;i<n-1;i++)
        {
            leftless=0;
            leftmore=0;
            rightless=0;
            rightmore=0;
            
            for(int j=i-1;j>=0;j--)
            {
                if(rating[j]<rating[i])
                    leftless++;
                else
                    leftmore++;
            }
            
            for(int j=i+1;j<n;j++)
            {
                if(rating[j]<rating[i])
                    rightless++;
                else
                    rightmore++;
            }
            
            ans+=leftless*rightmore+leftmore*rightless;
        }
        
        return ans;
    }
}