class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character,Integer> map=new HashMap();
        
        for(int i=0;i<order.length();i++)
        {
            map.put(order.charAt(i),i);
        }
        
        int n=words.length;
        
        for(int i=0;i<n-1;i++)
        {
            String w1=words[i], w2=words[i+1];
            int n1=w1.length(), n2=w2.length();
            
            if(n2<n1&&w2.equals(w1.substring(0,n2)))
                return false;
            
            for(int j=0;j<Math.min(n1,n2);j++)
            {
                if(w1.charAt(j)!=w2.charAt(j))
                {
                    if(map.get(w1.charAt(j))>map.get(w2.charAt(j)))
                        return false;
                    else
                        break;
                }
            }
            
        }
        
        return true;
    }
}