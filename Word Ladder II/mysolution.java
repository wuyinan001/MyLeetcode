class Solution {
    
    private boolean oneWordDiff(String s1, String s2)
    {
        int n=s1.length();
        int diff=0;
        
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        
        return diff==1;
    }
    
    private void backTrack(String input, String beginWord, Map<String,List<String>> prev, List<List<String>> ans, List<String> list)
    {
        if(input.equals(beginWord))
        {
            list.add(0,input);
            ans.add(list);
            return;
        }
        
        for(String s:prev.get(input))
        {
            List<String> newList=new ArrayList(list);
            newList.add(0,input);
            backTrack(s,beginWord,prev,ans,newList);
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> ans=new ArrayList();
        
        if(!wordList.contains(endWord))
            return ans;
        
        Map<String,List<String>> adj=new HashMap();
        Map<String,Integer> dist=new HashMap();
        Map<String,List<String>> prev=new HashMap();
        
        adj.put(beginWord,new ArrayList());
        dist.put(beginWord,0);
        
        for(String s:wordList)
        {
            adj.put(s,new ArrayList());
            dist.put(s,Integer.MAX_VALUE);
            prev.put(s,new ArrayList());
        }
        
        
            
        for(String word:wordList)
            if(oneWordDiff(beginWord,word))
            {
                adj.get(beginWord).add(word);
                adj.get(word).add(beginWord);
            }
        
        for(int i=0;i<wordList.size();i++)
        {
            for(int j=i+1;j<wordList.size();j++)
            {
                if(oneWordDiff(wordList.get(i),wordList.get(j)))
                {
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        
        Queue<String> queue=new LinkedList();
        queue.add(beginWord);
        
        while(!queue.isEmpty())
        {
            String temp=queue.remove();
            
            for(String neighbor:adj.get(temp))
            {
                if(dist.get(neighbor)>1+dist.get(temp))
                {
                    dist.put(neighbor,1+dist.get(temp));
                    queue.add(neighbor);
                }
                
                if(dist.get(neighbor)==1+dist.get(temp)&&!prev.get(neighbor).contains(temp))
                    prev.get(neighbor).add(temp);
            }
        }
        
        //print(adj);
        //print(prev);
        
        backTrack(endWord,beginWord,prev,ans,new ArrayList());
        
        return ans;
    }
    
    private void print(Map<String,List<String>> map)
    {
        for(String key:map.keySet())
        {
            System.out.print(key+" : ");
            for(String word:map.get(key))
                System.out.print(word+" ");
            System.out.println();
        }
    }
}