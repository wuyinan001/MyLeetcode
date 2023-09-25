class Solution {
    
    private String convert(int[][] board)
    {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++)
                sb.append(board[i][j]);
        
        return sb.toString();
    }
    
    private int[][] unconvert(String s)
    {
        int[][] ans=new int[2][3];
        
        for(int i=0;i<6;i++)
            ans[i/3][i%3]=s.charAt(i)-'0';
        
        return ans;
    }
    
    private int[] findZero(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
                return new int[]{i/3,i%3};
        }
        
        return new int[]{-1,-1};
    }
    
    private int[][] copyArray(int[][] array)
    {
        int n=array.length, m=array[0].length;
        int[][] ans=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[i][j]=array[i][j];
            }
        }
        
        return ans;
    }
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public int slidingPuzzle(int[][] board) {
        
        Queue<String> queue=new LinkedList();
        Set<String> set=new HashSet();
        int[][] start={{1,2,3},{4,5,0}};
        String target=convert(board);
        
        queue.add(convert(start));
        set.add(convert(start));
        
        int ans=0;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            for(int k=0;k<n;k++)
            {
                String temp=queue.remove();
                
                
                if(temp.equals(target))
                    return ans;
                
                int[][] curr=unconvert(temp);
                
                int[] zero_pos=findZero(temp);
                
                for(int kk=0;kk<4;kk++)
                {
                    int x=zero_pos[0]+dir[kk][0], y=zero_pos[1]+dir[kk][1];
                    
                    if(x>=0&&x<2&&y>=0&&y<3)
                    {
                        int[][] array=copyArray(curr);
                        
                        array[x][y]=curr[zero_pos[0]][zero_pos[1]];
                        array[zero_pos[0]][zero_pos[1]]=curr[x][y];
                        
                        String s=convert(array);
                        
                        if(!set.contains(s))
                        {
                            queue.add(s);
                            set.add(s);
                        }
                    }
                }
                
            }
                
            ans++;
        }
        
        return -1;
    }
}