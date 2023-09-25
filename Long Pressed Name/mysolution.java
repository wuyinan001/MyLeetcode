class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int n1=name.length(), n2=typed.length();
        
        int i=0,j=0;
        
        while(i<n1&&j<n2)
        {
            char c1=name.charAt(i), c2=typed.charAt(j);
            
            if(c1==c2)
            {
                i++;
                j++;
            }
            else if(j>0&&typed.charAt(j)==typed.charAt(j-1))
            {
                j++;
            }
            else
                return false;
        }
        
        while(j<n2&&typed.charAt(j)==typed.charAt(j-1))
            j++;
        
        return i==n1&&j==n2;
    }
}