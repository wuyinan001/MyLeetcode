class Solution {
    public int lengthOfLastWord(String s) {
        
        int n=s.length();
        
        int end=-1,start=-1;
        boolean end_found=false;
        
        for(int i=n-1;i>=0;i--)
        {
            if(!end_found&&isLetter(s.charAt(i)))
            {
                end_found=true;
                end=i;
            }
            
            if(end_found&&!isLetter(s.charAt(i)))
            {
                start=i;
                break;
            }
        }
        
        return end-start;
    }
    
    private boolean isLetter(char c)
    {
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            return true;
        else
            return false;
    }
}