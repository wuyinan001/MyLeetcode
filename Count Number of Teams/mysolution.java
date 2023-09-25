class Solution {
    public int numTeams(int[] rating) {
        
        int ans=0;
        int n=rating.length;
        
        for(int i=0;i<n;i++)
        {
           for(int j=i+1;j<n;j++)
           {
               if(rating[j]>rating[i])
               {
                   for(int k=j+1;k<n;k++)
                       if(rating[k]>rating[j])
                           ans++;
               }
           }
        }
        
        for(int i=0;i<n;i++)
        {
           for(int j=i+1;j<n;j++)
           {
               if(rating[j]<rating[i])
               {
                   for(int k=j+1;k<n;k++)
                       if(rating[k]<rating[j])
                           ans++;
               }
           }
        }
        
        return ans;
    }
}