class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans=new ArrayList();
        
        int n=matrix.length, m=matrix[0].length;
        
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
        int col_steps=m, row_steps=n-1;
        
        int x=0,y=-1;
        int direction=0;
        
        while(ans.size()<n*m)
        {            
            
            if(direction==0||direction==2)
            {
                for(int i=1;i<=col_steps;i++)
                {
                    y=y+dirs[direction][1];
                    ans.add(matrix[x][y]);
                }
                
                col_steps--;
            }
            else
            {
                for(int i=1;i<=row_steps;i++)
                {
                    x=x+dirs[direction][0];
                    ans.add(matrix[x][y]);
                }
                
                row_steps--;
            }
            
            direction=(direction+1)%4;
        }
        
        return ans;
    }
}