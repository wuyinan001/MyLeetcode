class Solution {
    public int countSubstrings(String s) {
        if(s.length()==0)
            return 0;
        
        //System.out.println(isSymmetric(s));
        int n=s.length();
        // count array count[i] shows number of palindromic substrings end at index i  
        int[] count=new int[n];
        
        count[0]=1;
        
        for(int j=1;j<n;j++)
        {
            int loc_count=0;
            
            for(int i=0;i<=j;i++)
            {
                if(isSymmetric(s.substring(i,j+1)))
                    loc_count++;
            }
            
            count[j]=count[j-1]+loc_count;
        }
        
        return count[n-1];
    }
    
    //Check if string s is symmetric
    private boolean isSymmetric(String s)
    {
        char[] str_array=s.toCharArray();
        int n=str_array.length;
        
        char[] reverse_array=new char[n];
        
        for(int i=0;i<n;i++)
            reverse_array[i]=str_array[n-1-i];
        
        for(int i=0;i<n;i++)
            if(str_array[i]!=reverse_array[i])
                return false;
        
        return true;
    }
}