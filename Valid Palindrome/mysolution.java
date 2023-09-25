class Solution {
    public boolean isPalindrome(String s) {
        
        String[] str=s.split("[^A-Za-z0-9]");
        
        //for(int i=0;i<str.length;i++)
          //  System.out.println("str[i]:"+str[i]);
        
        // Remove all non-alphanumeric characters
        s=String.join("",str);
        
        //System.out.println("s:"+s);
        
        if(s.equals(""))
            return true;
        
        int i=0,j=s.length()-1;
        
        char[] array=s.toCharArray();
        
        while(i<=j)
        {
            if(array[i]<='Z'&&array[i]>='A')
                array[i]=(char)((int)array[i]+(int)'a'-(int)'A');
            
            if(array[j]<='Z'&&array[j]>='A')
                array[j]=(char)((int)array[j]+(int)'a'-(int)'A');
            
            if(array[i]!=array[j])
            {
                //System.out.println("a[i],a[j]:"+array[i]+" "+array[j]);
                //System.out.println("i j:"+i+" "+j);
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}