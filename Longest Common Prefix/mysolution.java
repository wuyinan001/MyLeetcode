class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        
        if(n==0)
            return "";
        
        // The min length of string
        int min=1000;
        int min_index=-1;
        
        for(int i=0;i<n;i++)
        {
            if(min>strs[i].length())
            {
                min=strs[i].length();
                min_index=i;
            } 
        }
        
        if(min==0)
            return "";
        
        for(int i=0;i<min;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!strs[j].substring(0,i+1).equals(strs[(j+1)%n].substring(0,i+1)))
                    return strs[0].substring(0,i);
            }
        }
        
        return strs[min_index];
    }
}