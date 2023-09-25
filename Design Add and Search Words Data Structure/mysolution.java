class WordDictionary {
    
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
        
        public char getChar()
        {
            return character;
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
            if(word==null||word.length()==0)
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
                return;
            }
            else
            {
                child.addWord(word.substring(1));
            }
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        
        root.addWord(word);
    }
    
    private boolean searchNode(String word, TrieNode t)
    {
        if(word.length()==0)
        {
            return t.terminate;
        }

        char c=word.charAt(0);
        
        if(c=='.')
        {
            for(TrieNode child:t.children.values())
            {
                if(searchNode(word.substring(1),child))
                    return true;
            }
            
            return false;
        }
        else
        {
            TrieNode child=t.getChild(c);
            
            if(child==null)
                return false;
            else
                return searchNode(word.substring(1),child);
        }
    }
    
    public boolean search(String word) {
        
        return searchNode(word,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */