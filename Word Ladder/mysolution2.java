class Solution {
    
    // Check if there is only one char diff between s1 and s2
    private boolean oneDiff(String s1, String s2)
    {
        if(s1.length()!=s2.length()||s1.equals(s2))
            return false;
        
        int count=0;
        
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                count++;
                if(count>1)
                    return false;
            }
        }
        
        return true;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue=new LinkedList();
        Set<String> set=new HashSet();
        
        queue.add(beginWord);
        set.add(beginWord);
        
        int ans=1;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            /*
            for(String word:queue)
                System.out.print(word+" ");
            System.out.println();*/
            
            for(int i=0;i<n;i++)
            {
                String temp=queue.remove();
                
                if(temp.equals(endWord))
                    return ans;
                
                for(String word:wordList)
                {
                    if(!set.contains(word)&&oneDiff(temp,word))
                    {
                        queue.add(word);
                        set.add(word);
                    }
                }
            }
            
            ans++;
        }
        
        return 0;
    }
}