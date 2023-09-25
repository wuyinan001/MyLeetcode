class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        char[] parray=pattern.toCharArray();
        String[] strarray=str.split(" ");
        
        if(parray.length!=strarray.length)
            return  false;
        
        int n=parray.length;
        
        Map<Character,Integer> map1=new HashMap<>();
        Map<String, Integer> map2=new HashMap<>();
        
        int[] a1=new int[n];
        int[] a2=new int[n];
        
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            if(map1.containsKey(parray[i]))
                a1[i]=map1.get(parray[i]);
            else
            {
                count++;
                map1.put(parray[i],count);
                a1[i]=count;
            }
        }
        
        count=0;
        
        for(int i=0;i<n;i++)
        {
            if(map2.containsKey(strarray[i]))
                a2[i]=map2.get(strarray[i]);
            else
            {
                count++;
                map2.put(strarray[i],count);
                a2[i]=count;
            }
            
            if(a1[i]!=a2[i])
                return false;
        }
        
        return true;
    }
}