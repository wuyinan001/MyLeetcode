class Solution {
    
    int min=Integer.MAX_VALUE;
    
    private int distance(int x1, int y1, int x2, int y2)
    {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    
    private void dfs(int w, int[][] workers, int[][] bikes, int sum, boolean[] visited)
    {
        if(sum>min)
            return;
        
        if(w==workers.length)
        {
            min=Math.min(min,sum);
            return;
        }
        
        for(int i=0;i<bikes.length;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                dfs(w+1,workers,bikes,sum+distance(workers[w][0],workers[w][1],bikes[i][0],bikes[i][1]),visited);
                visited[i]=false;
            }
        }
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        
        boolean[] visited=new boolean[bikes.length];
        
        dfs(0,workers,bikes,0,visited);
        
        return min;
    }
}