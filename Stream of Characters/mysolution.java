class StreamChecker {

    private class TrieNode
    {
        private char character;
        private boolean terminate;
        private Map<Character,TrieNode> children;
        
        public TrieNode()
        {
            children=new HashMap();
        }
        
        public TrieNode(char c)
        {
            this();
            character=c;
        }
        
        public TrieNode getChild(char c)
        {
            return children.get(c);
        }
        
        public void setTerminate(boolean t)
        {
            terminate=t;
        }
        
        public void addWord(String word)
        {
            if(word==null||word.equals(""))
                return;
            
            char c=word.charAt(0);
            
            TrieNode child=getChild(c);
            
            if(child==null)
            {
                child=new TrieNode(c);
                children.put(c,child);
            }
            
            if(word.length()==1)
            {
                child.setTerminate(true);
            }
            else
                child.addWord(word.substring(1));
        }
    }
    
    public boolean findWord(TrieNode t, String word)
    {
        if(word.equals(""))
            return true;
        
        char c=word.charAt(0);
        
        if(!t.children.containsKey(c))
            return false;
        else
            return findWord(t.getChild(c),word.substring(1));
    }
    
    
    private TrieNode root;
    private Set<String> set;
  
    
    public StreamChecker(String[] words) {
        
        set=new HashSet();
        root=new TrieNode();
        
        for(String word:words)
        {
            StringBuilder sb=new StringBuilder(word);
            sb.reverse();
            set.add(sb.toString()); 
        }
    }
    
    public boolean query(char letter) {
        
        TrieNode t=new TrieNode(letter);
        
        t.children.put(letter,root);
        
        root=t;
        
        for(String word:set)
            if(findWord(root,word))
                return true;
        
        return  false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */