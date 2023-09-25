class Solution {
    public String reorderSpaces(String text) {
        
        StringBuilder sb=new StringBuilder();
        String[] strs=text.split(" ");
        
        List<String> words=new ArrayList();
        
        for(String s:strs)
            if(!s.equals(""))
                words.add(s);
        
        int numWords=words.size();
        
        int numSpace=0;
        
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)==' ')
                numSpace++;
        }
        
        if(numWords==1)
        {
            sb.append(words.get(0));
            
            for(int j=1;j<=numSpace;j++)
                sb.append(" ");
            
            return sb.toString();
        }

        int extra=numSpace%(numWords-1);
        int newSpace=numSpace/(numWords-1);

        for(int i=0;i<words.size();i++)
        {
            sb.append(words.get(i));
            
            if(i!=words.size()-1)
            {
                for(int j=1;j<=newSpace;j++)
                    sb.append(" ");
            }
            
        }
        
        for(int i=1;i<=extra;i++)
            sb.append(" ");
        
        return sb.toString();
    }
}