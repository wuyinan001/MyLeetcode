// In general, three points are in the same line if (p2[x]-p1[x])/(p3[x]-p1[x])==(p2[y]-p1[y])/(p3[y]-p1[y])
// Then be careful of the cases when denominators are zero

class Solution {
    public int maxPoints(int[][] points) {
        
        int max=0;
        int n=points.length;
        
        if(n<=1)
            return n;
          
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dx=points[j][0]-points[i][0], dy=points[j][1]-points[i][1];
                int count=2;
                
                for(int k=j+1;k<n;k++)
                {
                    int dx2=points[k][0]-points[i][0], dy2=points[k][1]-points[i][1];
                    
                    if(dx==0)
                    {
                        if(dx2!=0)
                            continue;
                        else
                            count++;
                    }
                    else if(dy==0)
                    {
                        if(dy2!=0)
                            continue;
                        else
                            count++;
                    }
                    else if((double)dx2/dx==(double)dy2/dy)
                        count++;
                }
                
                max=Math.max(max,count);
            }
        }
        
        return max;
    }
}