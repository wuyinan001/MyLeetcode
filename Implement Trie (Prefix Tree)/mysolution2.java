class Trie {
    
    private class TrieNode
    {
        private char character;
        private boolean terminate=false;
        private Map<Character,TrieNode> children;
        
        public TrieNode()
        {
            this.children=new HashMap<>();
        }
        
        public TrieNode(char character)
        {
            this();
            this.character=character;
        }
        
        public char getChar()
        {
            return character;
        }
        
        public TrieNode getChild(char c)
        {
            return children.get(c);
        }
        
        public boolean terminate()
        {
            return terminate;
        }
        
        public void setTerminate(boolean t)
        {
            terminate=t;
        }
        
        public void addWord(String word)
        {
            if(word==null||word.equals(""))
            {
                return;
            }
            
            char c=word.charAt(0);
            int n=word.length();
            
            TrieNode child=getChild(c);
            
            if(child==null)
            {
                child=new TrieNode(c);
                children.put(c,child);
            }
            
            if(word.length()>1)
            {
                child.addWord(word.substring(1));
            }
            else
                child.setTerminate(true);
        }
    }
    
    TrieNode root;
    
    
    /** Initialize your data structure here. */
    public Trie() {
        
        root=new TrieNode();
    }
    
    public Trie(String name)
    {
        this();
        root.addWord(name);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        root.addWord(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode curr=root;
        
        for(int i=0;i<word.length();i++)
        {   
            char c=word.charAt(i);
            
            if(curr!=null&&curr.children.containsKey(c))
                curr=curr.children.get(c);
            else
                return false;
        }
        
        return curr.terminate();
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode curr=root;
        
        for(int i=0;i<prefix.length();i++)
        {   
            char c=prefix.charAt(i);
            
            if(curr!=null&&curr.children.containsKey(c))
                curr=curr.children.get(c);
            else
                return false;
        }
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */