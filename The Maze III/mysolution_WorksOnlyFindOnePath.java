class Solution {
    
    private String findPath(Map<String,String> prev, String start, String end)
    {
        Stack<Character> stack=new Stack();
        
        String curr=end;
        
        while(!curr.equals(start))
        {
            String next=prev.get(curr);
            
            String[] strs1=curr.split("#");
            String[] strs2=next.split("#");
            
            int x1=Integer.parseInt(strs1[0]), y1=Integer.parseInt(strs1[1]);
            int x2=Integer.parseInt(strs2[0]), y2=Integer.parseInt(strs2[1]);
            
            if(x1<x2)
                stack.push('u');
            else if(x1>x2)
                stack.push('d');
            else if(y1<y2)
                stack.push('l');
            else
                stack.push('r');
            
            curr=next;
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.toString();
    }
    
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        
        int n=maze.length, m=maze[0].length;
        
        Queue<int[]> queue=new LinkedList();
        queue.add(ball);
        
        int[][] distance=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                distance[i][j]=Integer.MAX_VALUE;
        
        distance[ball[0]][ball[1]]=0;
        
        Map<String,String> prev=new HashMap();
        
        while(!queue.isEmpty())
        {
            int[] temp=queue.remove();
            
            for(int[] dir:dirs)
            {
                int x=temp[0], y=temp[1];
                int steps=0;
                
                while(x>=0&&x<n&&y>=0&&y<m&&maze[x][y]==0)
                {
                    if(x==hole[0]&&y==hole[1]&&distance[x][y]>distance[temp[0]][temp[1]]+steps)
                    {
                        distance[x][y]=distance[temp[0]][temp[1]]+steps;
                        prev.put(x+"#"+y,temp[0]+"#"+temp[1]);
                    }
                    x=x+dir[0];
                    y=y+dir[1];
                    steps++;
                }
                
                x=x-dir[0];
                y=y-dir[1];
                steps--;
                
                if(distance[x][y]>distance[temp[0]][temp[1]]+steps)
                {
                    System.out.println("x"+x+"y"+y);
                    queue.add(new int[]{x,y});
                    distance[x][y]=distance[temp[0]][temp[1]]+steps;
                    prev.put(x+"#"+y,temp[0]+"#"+temp[1]);
                }
            }
        }
        
        if(!prev.containsKey(hole[0]+"#"+hole[1]))
            return "impossible";
        
        return findPath(prev,ball[0]+"#"+ball[1],hole[0]+"#"+hole[1]);
    }
}