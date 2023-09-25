class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        
        int n=matrix.length, m=matrix[0].length;
        List<Integer> ans=new ArrayList();
        
        int x=0, y=-1;
        
        int hsteps=m, vsteps=n-1;
        int direction=0;
        
        while(ans.size()<n*m)
        {
            if(direction==0||direction==2)
            {
                for(int i=1;i<=hsteps;i++)
                {  
                    x=x+dir[direction][0];
                    y=y+dir[direction][1];
                    
                    //System.out.println("x "+x+" y "+y);

                    ans.add(matrix[x][y]);
                }
                
                hsteps--;
            }
            else
            {
                for(int i=1;i<=vsteps;i++)
                {
                    x=x+dir[direction][0];
                    y=y+dir[direction][1];
                    
                    //System.out.println("x "+x+" y "+y);

                    ans.add(matrix[x][y]);
                }
                
                vsteps--;
            }
            
            
            direction=(direction+1)%4;
        }
        
        return ans;
        
    }
}