class Trie {
    
    private String name;
    private Trie[] children;
    private boolean end=false;
    
    
    /** Initialize your data structure here. */
    public Trie() {
        
        children=new Trie[26];
    }
    
    public Trie(String name)
    {
        this.name=name;
        children=new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        int n=word.length();
        
        if(n==1)
        {
            if(this.children[word.charAt(0)-'a']==null)
                this.children[word.charAt(0)-'a']=new Trie(word);
            this.children[word.charAt(0)-'a'].end=true;
            
        }
        else
        {
            if(this.children[word.charAt(0)-'a']==null)
                this.children[word.charAt(0)-'a']=new Trie(word.substring(0,1));
            this.children[word.charAt(0)-'a'].insert(word.substring(1,n));
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        if(word.equals("")&&this.end)
            return true;
        else if(word.equals("")&&!this.end)
            return false;
        
        if(this.children[word.charAt(0)-'a']==null)
            return false;
        
        return this.children[word.charAt(0)-'a'].search(word.substring(1,word.length()));
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        if(prefix.equals(""))
            return true;
        
        if(this.children[prefix.charAt(0)-'a']==null)
            return false;
        
        return this.children[prefix.charAt(0)-'a'].startsWith(prefix.substring(1,prefix.length()));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */