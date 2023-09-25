class Solution {
    public boolean isStrobogrammatic(String num) {
        
        StringBuilder sb=new StringBuilder();
        Set<Character> set=new HashSet();
        
        set.add('0');
        set.add('1');
        set.add('6');
        set.add('8');
        set.add('9');
        
        for(int i=0;i<num.length();i++)
        {
            char c=num.charAt(i);
            
            if(!set.contains(c))
                return false;
            
            if(c=='6')
                sb.append('9');
            else if(c=='9')
                sb.append('6');
            else
                sb.append(c);
        }
        
        return num.equals(sb.reverse().toString());
    }
}