class Solution {
    public String reverseWords(String s) {
        
        if(s.equals(""))
            return "";
        
        String[] array=s.split("\\s+");
        
        int n=array.length;
        
        if(n==0)
            return "";
        
        // Remove the first element if not a string
        if(array[0].equals(""))
        {
            array=resize(array,n-1);
            n=array.length;
        }
        
        //print(array);
        
        int mid=(n-1)/2;
        
        for(int i=0;i<=mid;i++)
        {
            String temp=array[i];
            array[i]=array[n-1-i];
            array[n-1-i]=temp;
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n-1;i++)
        {
            sb.append(array[i]);
            sb.append(" ");
        }
        
        sb.append(array[n-1]);
        
        return sb.toString();
    }
    
    private void print(String[] a)
    {
        int n=a.length;

        for(int i=0;i<n;i++)
        {
            System.out.println(i+": "+a[i]);
        }
    }
    
    private String[] resize(String[] a, int k)
    {
        String[] temp=new String[k];
        
        for(int i=0;i<k;i++)
        {
            temp[i]=a[i+a.length-k];
        }
        
        return temp;
    }
}