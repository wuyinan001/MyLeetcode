class Solution {
    public String removeVowels(String s) {
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u')
                sb.append(c);
        }
        
        return sb.toString();
    }
}