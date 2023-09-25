class Solution {
    public boolean isPalindrome(String s) {
        
        List<Character> list=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c>='A'&&c<='Z')
            {
                c=Character.toLowerCase(c);
                list.add(c);
            }
            else if((c>='a'&&c<='z')||(c>='0'&&c<='9'))
                list.add(c);
                
        }
        
        if(list.isEmpty())
            return true;
        
        int n=list.size();
        
        for(int i=0;i<n/2;i++)
        {
            if(list.get(i)!=list.get(n-1-i))
                return false;
        }
        
        return true;
    }
}