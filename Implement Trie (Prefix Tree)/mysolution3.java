class Trie {
    
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
    public Trie() {
        
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        root.addWord(word);
    }
    
    private boolean search(String word, TrieNode t)
    {
        if(word.length()==0)
        {
            return t.terminate;
        }
        
        char c=word.charAt(0);
        
        if(t.children.containsKey(c))
        {
            return search(word.substring(1),t.getChild(c));
        }
        else
            return false;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return search(word,root);
        
    }
    
    private boolean startsWith(String word, TrieNode t)
    {
        if(word.length()==0)
        {
            return true;
        }
        
        char c=word.charAt(0);
        
        if(t.children.containsKey(c))
        {
            return startsWith(word.substring(1),t.getChild(c));
        }
        else
            return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        return startsWith(prefix,root);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */