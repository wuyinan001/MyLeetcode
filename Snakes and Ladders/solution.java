class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n=board.length;
        
        int[] map=new int[n*n+1];
        
        boolean right=true;
        int count=1;
        
        for(int i=n-1;i>=0;i--)
        {
            if(right)
            {
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]!=-1)
                        map[count]=board[i][j];
                    count++;
                }
                right=false;
            }
            else
            {
                for(int j=n-1;j>=0;j--)
                {
                    if(board[i][j]!=-1)
                        map[count]=board[i][j];
                    count++;
                }
                right=true;
            }
        }
        
        Queue<Integer> queue=new LinkedList();
        boolean[] visited=new boolean[n*n+1];
        queue.add(1);
        visited[1]=true;
        
        int step=0;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=1;i<=size;i++)
            {
                int temp=queue.remove();
                
                if(temp==n*n)
                    return step;
                
                for(int next=temp+1;next<=temp+6;next++)
                {
                    if(next<=n*n&&!visited[next])
                    {
                        if(map[next]!=0)
                            queue.add(map[next]);
                        else
                            queue.add(next);
                        
                        visited[next]=true;
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
}