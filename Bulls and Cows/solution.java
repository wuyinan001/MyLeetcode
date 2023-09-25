class Solution {
    public String getHint(String secret, String guess) {
        
        char[] array1=secret.toCharArray();
        char[] array2=guess.toCharArray();
        
        int n=array1.length;

        int a=0,b=0;
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            if(array1[i]==array2[i])
                a++;
        }
        
        if(n==a)
            return a+"A"+0+"B";
        
        char[] c1=new char[n-a];
        char[] c2=new char[n-a];
        
        for(int i=0;i<n;i++)
        {
            if(array1[i]!=array2[i])
            {
                c1[count]=array1[i];
                c2[count]=array2[i];
                count++;
            }
            
        }
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        //print(c1);
        //print(c2);

        
        int i=0,j=0;
        
        while(i<n-a&&j<n-a)
        {
            //System.out.println("c1[i]: "+c1[i]+" c2[j]: "+c2[j]+"b: "+b);
            
            if(c1[i]==c2[j])
            {
                i++;
                j++;
                b++;
            }
            else if(c1[i]<c2[j])
                i++;
            else
                j++;
            
            //System.out.println("i: "+i+" j: "+j+"b: "+b);
        }
        
        return a+"A"+b+"B";
    }
    
    private void print(char[] a)
    {
        int n=a.length;
        
        for(int i=0;i<n;i++)
            System.out.println(i+":"+a[i]+" ");
        System.out.println();
    }
}