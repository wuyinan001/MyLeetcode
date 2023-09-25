class Solution {
    
    private void clearArray(boolean[][] visited)
    {
        int n=visited.length, m=visited[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                visited[i][j]=false;
    }
    
    public int shortestDistance(int[][] grid) {
        
        Map<Pair<Integer,Integer>,List<Integer>> map=new HashMap();
        
        int numOfBuildings=0;
        int n=grid.length, m=grid[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited=new boolean[n][m];
        
        Queue<int[]> queue=new LinkedList();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    numOfBuildings++;
                    clearArray(visited);
                    queue.add(new int[]{i,j});
                    int x0=i, y0=j;
                    
                    // dst is num of steps to house i,j
                    int dst=1;
                    
                    while(!queue.isEmpty())
                    {
                        int size=queue.size();
                        
                        for(int k=1;k<=size;k++)
                        {
                            int[] temp=queue.remove();
                        
                            for(int[] dir:dirs)
                            {
                                int x=temp[0]+dir[0], y=temp[1]+dir[1];
                                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==0&&!visited[x][y])
                                {
                                    queue.add(new int[]{x,y});
                                    visited[x][y]=true;
                                    Pair<Integer,Integer> pair=new Pair(x,y);
                                    if(!map.containsKey(pair))
                                        map.put(pair,new ArrayList());

                                    map.get(pair).add(dst);
                                }
                            }
                        }
                        
                        dst++;
                        
                    }
                }
            }
        }
        
        //print(map);
        
        int ans=Integer.MAX_VALUE;
        
        for(Pair<Integer,Integer> pair:map.keySet())
        {
            if(map.get(pair).size()==numOfBuildings)
            {
                int sum=0;
                
                for(int d:map.get(pair))
                    sum+=d;
                
                ans=Math.min(ans,sum);
            }
        }
        
        if(ans==Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
    
    // To check the steps to each house from every empty location
    private void print(Map<Pair<Integer,Integer>,List<Integer>> map)
    {
        for(Pair<Integer,Integer> pair:map.keySet())
        {
            System.out.print(pair.getKey()+","+pair.getValue()+" : ");
            int sum=0;
            for(int i:map.get(pair))
            {
                System.out.print(i+" ");
                sum+=i;
            }
            System.out.print(" sum: "+sum);
            System.out.println();
        }
    }
}