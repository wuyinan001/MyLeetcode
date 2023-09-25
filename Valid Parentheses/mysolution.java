class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        int n=s.length();
        
        if(n==0)
            return true;
        
        char[] array=s.toCharArray();
        
        
        int[] c1=new int[n];
        int[] s1=new int[n];
        int[] c2=new int[n];
        int[] s2=new int[n];
        int[] c3=new int[n];
        int[] s3=new int[n];
        
        int i=0;
        
        for(char c:array)
            stack.push(c);
        
        while(!stack.isEmpty())
        {   
            
            char c=stack.pop();
            
            if(c==')')
            {
                c1[i]=1;
            }
                
            else if(c==']')
            {
                c2[i]=1;
            }
                
            else if(c=='}')
            {
                c3[i]=1;
            }
                
            else if(c=='(')
            {
                c1[i]=-1;
            }
                
            else if(c=='[')
            {
                c2[i]=-1;
            }
                
            else
            {
                c3[i]=-1;
            }
            
            if(i>0)
                s1[i]=s1[i-1]+c1[i];
            else
                s1[i]=c1[i];
            
            if(i>0)
                s2[i]=s2[i-1]+c2[i];
            else
                s2[i]=c2[i];
            
            if(i>0)
                s3[i]=s3[i-1]+c3[i];
            else
                s3[i]=c3[i];
            
            if(c1[i]<0&&s1[i]<0)
            {
                System.out.println("i: "+i);
                return false;
            }
                
            
            if(c2[i]<0&&s2[i]<0)
            {
                System.out.println("i: "+i);
                return false;
            }
              
            
            if(c3[i]<0&&s3[i]<0)
            {
                System.out.println("i: "+i);
                return false;
            }
                
            
            if(c1[i]<0)
            {
                int j;
                for(j=i-1;j>=0;j--)
                {
                    if(c1[j]>0&&s1[j]==s1[i]+1)
                        break;
                }
                
                if(s2[i]!=s2[j])
                {
                    System.out.println("i: "+i);
                    return false;
                } 
                
                if(s3[i]!=s3[j])
                {
                    System.out.println("i: "+i);
                    return false;
                }
                    
            }
            
            if(c2[i]<0)
            {
                int j;
                for(j=i-1;j>=0;j--)
                {
                    if(c2[j]>0&&s2[j]==s2[i]+1)
                        break;
                }
                
                if(s1[i]!=s1[j])
                {
                    System.out.println("i: "+i);
                    return false;
                }
                    
                
                if(s3[i]!=s3[j])
                {
                    System.out.println("i: "+i);
                    return false;
                }
                
                    
            }
            
            if(c3[i]<0)
            {
                int j;
                for(j=i-1;j>=0;j--)
                {
                    if(c3[j]>0&&s3[j]==s3[i]+1)
                        break;
                }
                
                if(s1[i]!=s1[j])
                {
                    System.out.println("i: "+i);
                    return false;
                }
                
                if(s2[i]!=s2[j])
                {
                    System.out.println("i: "+i);
                    return false;
                }
            }
            
            i++;
             
        }
        
        if(s1[i-1]!=0||s2[i-1]!=0||s3[i-1]!=0)
            return false;
        
        return true;
    }
}