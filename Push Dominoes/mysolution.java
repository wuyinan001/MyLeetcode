class Solution {
    public String pushDominoes(String dominoes) {
        
        int n=dominoes.length();
        
        if(n<=1)
            return dominoes;
        
        while(true)
        {
            char[] curr=dominoes.toCharArray();
            char[] curr2=dominoes.toCharArray();
            
            if(curr[0]=='.'&&curr[1]=='L')
                curr2[0]='L';    
            
            if(curr[n-1]=='.'&&curr[n-2]=='R')
                curr2[n-1]='R';
            
            for(int i=1;i<n-1;i++)
            {
                if(curr2[i]=='.')
                {
                    if(curr[i-1]=='R'&&curr[i+1]!='L')
                    {
                        curr2[i]='R';
                    }
                    else if(curr[i+1]=='L'&&curr[i-1]!='R')
                    {
                        curr2[i]='L';
                    }
                }
            }
            
            String newStr=new String(curr2);
            
            //System.out.println(newStr);
            
            if(newStr.equals(dominoes))
                break;
            else
                dominoes=newStr;
        }
        
        return dominoes;
    }
}