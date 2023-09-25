class Solution {
    
    /*
        There are mainly three steps in this solution:
        
        1. Construct a graph based on the beginWord and wordList;
        2. Run BFS. Find the shortest paths of each node and update the prev nodes to that node in those paths;
        3. Retrieving paths based on prev map.
        
        printMap() is for debugging and validating the steps only.
    
    */
    
    private boolean oneCharDiff(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        
        int diff=0;
        
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        
        return diff==1;
    }
    
    private void printMap(Map<String,List<String>> map)
    {
        for(String key:map.keySet())
        {
            List<String> list=map.get(key);
            
            System.out.print(key+" : ");
            
            for(String s:list)
                System.out.print(s+",");
            
            System.out.println();
        }
    }
    
    private void backTrack(String beginWord, String word,List<List<String>> list,List<String> list2, Map<String,List<String>> prev)
    {
        if(word.equals(beginWord))
        {
            list2.add(word);
            Collections.reverse(list2);
            list.add(list2);
            return;
        }
        
        list2.add(word);
        
        List<String> prevList=prev.get(word);
        
        for(int i=0;i<prevList.size();i++)
        {
            List<String> newList=new ArrayList(list2);
            backTrack(beginWord,prevList.get(i),list,newList,prev);
        }
        
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> ans=new ArrayList();
        
        Map<String,List<String>> adj=new HashMap();
        Map<String,List<String>> prev=new HashMap();
        Map<String,Integer> dist=new HashMap();
        
        adj.put(beginWord,new ArrayList());
        dist.put(beginWord,0);
        
        for(String word:wordList)
        {
            adj.put(word,new ArrayList());
            prev.put(word,new ArrayList());
            dist.put(word,Integer.MAX_VALUE);
        }
        
        if(!adj.containsKey(endWord))
            return ans;
        
        for(String word:wordList)
        {
            if(oneCharDiff(beginWord,word))
            {
                if(!adj.get(beginWord).contains(word))
                    adj.get(beginWord).add(word);
                
                if(!adj.get(word).contains(beginWord))
                    adj.get(word).add(beginWord);
            }
        }
        
        for(int i=0;i<wordList.size();i++)
        {
            for(int j=i+1;j<wordList.size();j++)
            {
                if(oneCharDiff(wordList.get(i),wordList.get(j)))
                {
                    if(!adj.get(wordList.get(i)).contains(wordList.get(j)))
                        adj.get(wordList.get(i)).add(wordList.get(j));

                    if(!adj.get(wordList.get(j)).contains(wordList.get(i)))
                        adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
            
        }
        
        //printMap(adj);
        Queue<String> queue=new LinkedList();
        
        queue.add(beginWord);
        
        while(!queue.isEmpty())
        {
            String word=queue.remove();
            
            for(String neighbor:adj.get(word))
            {
                if(dist.get(neighbor)>dist.get(word)+1)
                {
                    prev.get(neighbor).clear();
                    dist.put(neighbor,dist.get(word)+1);
                    prev.get(neighbor).add(word);
                    queue.add(neighbor);
                }
                else if(dist.get(neighbor)==dist.get(word)+1)
                {
                    prev.get(neighbor).add(word);
                }
            }
        }
        
        //printMap(prev);
        
        // Retrieving paths
        backTrack(beginWord,endWord,ans,new ArrayList(),prev);
        
        return ans;
    }
}