class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int n=coordinates.length;
        
        // Determine the line function of the first two coordinates
        // x=a or y=k*x+b
        
        if(coordinates[0][0]==coordinates[1][0])
        {
            int a=coordinates[0][0];
            
            for(int i=2;i<n;i++)
            {
                if(coordinates[i][0]!=a)
                    return false;
            }
            
            return true;
        }
        else
        {
            double k=((double)coordinates[1][1]-(double)coordinates[0][1])/((double)coordinates[1][0]-(double)coordinates[0][0]);
            
            for(int i=1;i<n-1;i++)
            {
                if(((double)coordinates[i+1][1]-(double)coordinates[i][1])/((double)coordinates[i+1][0]-(double)coordinates[i][0])!=k)
                    return false;
            }
            
            return true;
        }
        
    }
}