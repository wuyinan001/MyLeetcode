class Solution {
    public boolean checkRecord(String s) {
        
        int n=s.length();
        
        int a=0,b=0,max=0;
        
        if(s.charAt(0)=='A')
            a++;
        else if(s.charAt(0)=='L')
            b++;
        
        for(int i=1;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c=='L')
            {
                if(b==2)
                    max=3;
                else
                    b++;
            }
            else
            {
                b=0;
                if(c=='A')
                    a++;
            }
        }
        
        return a<2&&!(max==3);
        
    }
}