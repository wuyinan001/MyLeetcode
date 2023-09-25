class Solution {
    
    
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n=s.length(), m=indices.length;
        
        Map<Pair<Integer,Integer>,String> map=new HashMap();
        
        for(int i=0;i<m;i++)
        {
            int len=sources[i].length();
            
            if(s.substring(indices[i],indices[i]+len).equals(sources[i]))
            {
                map.put(new Pair(indices[i],indices[i]+len-1),targets[i]);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        int curr=0;
        
        List<Pair<Integer,Integer>> list=new ArrayList(map.keySet());
        
        Collections.sort(list,new Comparator<Pair<Integer,Integer>>(){
            
            public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2)
            {
                return p1.getKey()-p2.getKey();
            }
            
        });
        
        for(Pair<Integer,Integer> p:list)
        {
            if(curr<p.getKey())
                sb.append(s.substring(curr,p.getKey()));
            
            sb.append(map.get(p));
            
            curr=p.getValue()+1;
        }
        
        if(curr<n)
            sb.append(s.substring(curr));
        
        return sb.toString();
    }
}