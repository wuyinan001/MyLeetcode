class Solution {
    public String reverseVowels(String s) {
        
        char[] array=s.toCharArray();
        
        int n=array.length;
        
        int i=0,j=n-1;
        
        while(i<j)
        {
            while(array[i]!='a'&&array[i]!='e'&&array[i]!='i'&&array[i]!='o'&&array[i]!='u'&&
                 array[i]!='A'&&array[i]!='E'&&array[i]!='I'&&array[i]!='O'&&array[i]!='U')
            {
                i++;
                if(i>=j)
                    break;
            }
            
            while(array[j]!='a'&&array[j]!='e'&&array[j]!='i'&&array[j]!='o'&&array[j]!='u'&&
                 array[j]!='A'&&array[j]!='E'&&array[j]!='I'&&array[j]!='O'&&array[j]!='U')
            {
                j--;
                if(i>=j)
                    break;
            }
            
            if(i<j)
            {
                char t=array[i];
                array[i]=array[j];
                array[j]=t;
                
                i++;
                j--;
            }
        }
        
        return new String(array);
    }
}