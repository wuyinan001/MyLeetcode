class Solution {
    public boolean buddyStrings(String a, String b) {
        
        if(a.length()!=b.length())
            return false;
        
        int n=a.length();
        
        if(a.equals(b))
        {
            int[] index=new int[26];
            
            for(int i=0;i<n;i++)
            {
                index[a.charAt(i)-'a']++;
                if(index[a.charAt(i)-'a']>1)
                    return  true;
            }
            
            return false;
        }
        
        char[][] diff=new char[2][2];
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                if(count>=2)
                    return false;
                diff[count][0]=a.charAt(i);
                diff[count][1]=b.charAt(i);
                count++;
            }
        }
        
        if(count<2)
            return false;
        
        return (diff[0][0]==diff[1][1])&&(diff[1][0]==diff[0][1]);
    }
}