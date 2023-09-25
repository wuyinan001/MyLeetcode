class Solution {
    
    int n;
    
    private int backTrack(char[] a1, char[] a2, int index)
    {
        if(index==n)
            return 0;
        
        if(a1[index]==a2[index])
        {
            return backTrack(a1,a2,index+1);
        }
                  
        int ans=Integer.MAX_VALUE;      

        for(int i=index+1;i<n;i++)
        {
            if(a1[i]==a2[index]&&a1[i]!=a2[i])
            {
                swap(a1,i,index);
                
                ans=Math.min(backTrack(a1,a2,index+1),ans);
                
                swap(a1,i,index);
            }
        }
        
        return ans+1;
    }
    
    public int kSimilarity(String s1, String s2) {
        
        n=s1.length();
        
        return backTrack(s1.toCharArray(),s2.toCharArray(),0);
    }
    
    private void swap(char[] array, int i, int j)
    {
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}