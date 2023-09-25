class Solution {
    public String addBinary(String a, String b) {
        
        int n1=a.length(), n2=b.length();
        int n=Math.min(n1,n2);
        
        StringBuilder sb=new StringBuilder();
        
        int carry=0;
        
        for(int i=0;i<n;i++)
        {
            int c1=a.charAt(n1-1-i)-'0', c2=b.charAt(n2-1-i)-'0';
            
            int sum=carry+c1+c2;
            
            sb.append(sum%2);
            carry=sum/2;
        }
        
        for(int i=n1-n-1;i>=0;i--)
        {
            int c=a.charAt(i)-'0';
            
            int sum=c+carry;
            sb.append(sum%2);
            carry=sum/2;
            
            //System.out.println("sum: "+sum);
            //System.out.println("carry: "+carry);
        }
        
        for(int i=n2-n-1;i>=0;i--)
        {
            int c=b.charAt(i)-'0';
            
            int sum=c+carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        
        if(carry==1)
        {
            //System.out.println("carry: "+carry);
            sb.append(1);
        }
            
        
        return sb.reverse().toString();
    }
}