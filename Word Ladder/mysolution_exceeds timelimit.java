class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord))
            return 0;
    
        
        int n=wordList.size();
        boolean[] marked=new boolean[n];
        HashMap<String,String> edgeTo=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        
        queue.add(beginWord);
        
        while(!queue.isEmpty())
        {
            String wordToCheck=queue.remove();
            
            for(int i=0;i<wordList.size();i++)
                if(oneWordChange(wordToCheck,wordList.get(i))&&!marked[i])
                {
                    queue.add(wordList.get(i));
                    marked[i]=true;
                    edgeTo.put(wordList.get(i),wordToCheck);
                }
            
            if(edgeTo.containsKey(endWord))
                break;
        }
        
        //print(edgeTo);
        
        if(!edgeTo.containsKey(endWord))
            return 0;
        else
        {
            int ans=0;
            
            for(String x=endWord;!x.equals(beginWord);x=edgeTo.get(x))
            {
                //System.out.println("x: "+x);
                ans++;
            }
            ans++;
            
            return ans;
        }
    }
    
    private void print(Map<String,String> map)
    {
        for(String key:map.keySet())
        {
            System.out.println("Key: "+key+"; Value: "+map.get(key));
        }
    }
    
    private boolean oneWordChange(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        
        int n=0;
        
        for(int i=0;i<s1.length();i++)
        {
            if(!s1.substring(i,i+1).equals(s2.substring(i,i+1)))
                n++;
        }
        
        return n==1;
    }
}