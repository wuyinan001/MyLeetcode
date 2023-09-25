class Solution {
    public int totalFruit(int[] tree) {
        
        int n=tree.length;
        Map<Integer,Integer> map=new HashMap();
        
        int ans=0;
        
        int start=0, end=0;
        
        while(end<n)
        {
            map.put(tree[end],map.getOrDefault(tree[end],0)+1);
            
            if(map.size()>2)
            {
                ans=Math.max(ans,end-start);
                
                while(map.size()>2)
                {
                    if(map.get(tree[start])==1)
                        map.remove(tree[start]);
                    else
                        map.put(tree[start],map.get(tree[start])-1);
                    
                    start++;
                }

            }
            
            end++;
        }
        
        if(map.size()<=2)
        {
            ans=Math.max(ans,end-start);
        }
            
        
        return ans;
        
    }
}