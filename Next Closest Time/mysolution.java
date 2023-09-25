class Solution {
    public String nextClosestTime(String time) {
        
        time=time.substring(0,2)+time.substring(3,5);
        
        List<Character> list=new ArrayList();
        
        for(int i=0;i<4;i++)
        {
            char c=time.charAt(i);
            if(!list.contains(c))
                list.add(c);
        }
        
        Collections.sort(list);
        
        char start=list.get(0);
        
        StringBuilder ans=new StringBuilder();
        
        for(char c:list)
        {
            if(c>time.charAt(3))
            {
                ans.append(time.substring(0,2));
                ans.append(":");
                ans.append(time.charAt(2));
                ans.append(c);
                return ans.toString();
            }
        }
        
        
        for(char c:list)
        {
            if(c>time.charAt(2)&&c<'6')
            {
                ans.append(time.substring(0,2));
                ans.append(":");
                ans.append(c);
                ans.append(start);
                return ans.toString();
            }
        }
        
        for(char c:list)
        {
            if(time.charAt(0)=='2')
            {
                if(c>time.charAt(1)&&c<'4')
                {
                    ans.append(time.substring(0,1));
                    ans.append(c);
                    ans.append(":");
                    ans.append(start);
                    ans.append(start);
                    return ans.toString();
                }
                    
            }
            else
            {
                if(c>time.charAt(1))
                {
                    ans.append(time.substring(0,1));
                    ans.append(c);
                    ans.append(":");
                    ans.append(start);
                    ans.append(start);
                    return ans.toString();
                }
            }
        }
        
        for(char c:list)
        {
            if(c>time.charAt(0)&&c<'3')
            {
                ans.append(c);
                ans.append(start);
                ans.append(":");
                ans.append(start);
                ans.append(start);
                return ans.toString();
            }
        }
        
        ans.append(start);
        ans.append(start);
        ans.append(':');
        ans.append(start);
        ans.append(start);
        
        return ans.toString();
    }
}