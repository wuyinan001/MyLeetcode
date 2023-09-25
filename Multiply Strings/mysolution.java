class Solution {
    
    public String multiply(String num1, String num2) {
        
        int n1=num1.length(), n2=num2.length();
        int[] product=new int[n1+n2];
        
        int prev_carry=0, j;
        
        for(int i=n2-1;i>=0;i--)
        {
            for(j=n1-1;j>=0;j--)
            {
                int mul=(num1.charAt(j)-'0')*(num2.charAt(i)-'0');
                
                int low=mul%10;
                
                //System.out.println("mul "+mul+" prev_carry "+prev_carry);
                
                product[i+j+1]=product[i+j+1]+mul+prev_carry;
                
                low=product[i+j+1]%10;
                prev_carry=product[i+j+1]/10;
                
                product[i+j+1]=low;
                
            }
            
            if(prev_carry!=0)
                product[i+j+1]+=prev_carry;
            
            prev_carry=0;
            //print(product);
        }
        
        
        
        StringBuilder sb=new StringBuilder();
        
        for(int i:product)
            sb.append(i);
        
        while(sb.length()>1&&sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
    
    private void print(int[] array)
    {
        for(int i:array)
            System.out.print(i+" ");
        System.out.println();
    }
}