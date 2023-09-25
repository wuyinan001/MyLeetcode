class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
     
        int n=books.length;
        
        int[] K=new int[n];
        
        K[0]=books[0][1];
        
        for(int i=1;i<n;i++)
        {
            K[i]=K[i-1]+books[i][1];
            
            int sum_width=books[i][0], height=books[i][1];
            
            for(int j=i-1;j>=0;j--)
            {
                int candidate=0;
                
                sum_width+=books[j][0];
                if(sum_width>shelf_width)
                    break;
                
                height=Math.max(height,books[j][1]);
                if(j!=0)
                    candidate=height+K[j-1];
                else
                    candidate=height;
                
                K[i]=Math.min(K[i],candidate);
            }
        }
        
        return K[n-1];
        
    }
}