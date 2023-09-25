class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        
        int n=colors.length;
        List<Integer> ans=new ArrayList();
        Map<String,Integer> map=new HashMap();
        
        for(int[] query:queries)
        {
            if(map.containsKey(query[0]+"#"+query[1]))
            {
                ans.add(map.get(query[0]+"#"+query[1]));
                continue;
            }
            
            int index=query[0];
            
            if(colors[index]==query[1])
            {
                ans.add(0);
                map.put(query[0]+"#"+query[1],0);
                continue;
            }
            
            int d=1;
            
            for(;d<=Math.max(index,n-1-index);d++)
            {
                if(index-d>=0&&colors[index-d]==query[1])
                {
                    ans.add(d);
                    map.put(query[0]+"#"+query[1],d);
                    break;
                }
                
                if(index+d<n&&colors[index+d]==query[1])
                {
                    ans.add(d);
                    map.put(query[0]+"#"+query[1],d);
                    break;
                }
            }
            
            if(d==Math.max(index,n-1-index)+1)
            {
                ans.add(-1);
                map.put(query[0]+"#"+query[1],-1);
            }
                
        }
        
        return ans;
        
    }
}