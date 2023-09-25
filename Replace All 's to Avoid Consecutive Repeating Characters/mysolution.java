class Solution {
    public String modifyString(String s) {
        
        char[] array=s.toCharArray();
        int n=array.length;
        
        if(n==1&&s.equals("?"))
            return "a";
        
        if(array[0]=='?')
        {
            for(int i=0;i<26;i++)
            {
                char c=(char)(i+'a');
                
                if(c!=array[1])
                {
                    array[0]=c;
                    break;
                }
            }
        }
        
        if(array[n-1]=='?')
        {
            for(int i=0;i<26;i++)
            {
                char c=(char)(i+'a');
                
                if(c!=array[n-2])
                {
                    array[n-1]=c;
                    break;
                }
            }
        }
        
        for(int i=1;i<n-1;i++)
        {
            if(array[i]=='?')
            {
                for(int j=0;j<26;j++)
                {
                    char c=(char)(j+'a');

                    if(c!=array[i-1]&&c!=array[i+1])
                    {
                        array[i]=c;
                        break;
                    }
                }
            }
        }
        
        return new String(array);
    }
}