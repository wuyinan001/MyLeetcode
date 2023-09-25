class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        Map<Integer,Integer> map=new HashMap();
        
        for(int i:deck)
            map.put(i,map.getOrDefault(i,0)+1);
        
        List<Integer> list=new ArrayList();
        
        for(int i:map.values())
            if(!list.contains(i))
                list.add(i);
        
        Collections.sort(list);
        
        
        for(int k=2;k<=list.get(0);k++)
        {
            int count=0;
            for(int i:list)
            {
                if(i%k!=0)
                    break;
                count++;
            }
            
            if(count==list.size())
                return true;
        }
        
        return false;
    }
}