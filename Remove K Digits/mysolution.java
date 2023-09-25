class Solution {
    public String removeKdigits(String num, int k) {

        while(k>0)
        {
            int n=num.length();
            int i=0;
            for(;i<n-1;i++) 
            {
                if(num.charAt(i)>num.charAt(i+1))
                {
                    num=num.substring(0,i)+num.substring(i+1);
                    break;
                }
                    
            }
            
            if(i==n-1)
                num=num.substring(0,i)+num.substring(i+1);
            
            k--;
        }
        
        while(!num.isEmpty()&&num.charAt(0)=='0')
            num=num.substring(1);
        
        if(num.equals(""))
            return "0";
        
        return num;
    }
}