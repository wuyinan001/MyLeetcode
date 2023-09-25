class Solution {
    public int expressiveWords(String S, String[] words) {
        
        RLE R=new RLE(S);
        int result=0;
        
        search: for(String word:words)
        {
            RLE R2=new RLE(word);
            
            if(!R.key.equals(R2.key))
                continue;
            
            int n=R.key.length();
            
            for(int i=0;i<n;i++)
            {
                int c1=R.count.get(i);
                int c2=R2.count.get(i);
                if(c1<c2||(c1<3&&c1!=c2))
                    continue search;
            }
            
            result++;
        }
        
        return result;
    }
    
}

class RLE
{
    String key;
    List<Integer> count;
    
    public RLE(String s)
    {
        StringBuilder sb=new StringBuilder();
        count=new ArrayList<Integer>();
        
        char[] array=s.toCharArray();
        
        int n=array.length;
        int prev=-1;
        
        for(int i=0;i<n;i++)
        {
            if(i==n-1||array[i]!=array[i+1])
            {
                sb.append(array[i]);
                count.add(i-prev);
                prev=i;
            }
        }
        
        key=sb.toString();
    }
}