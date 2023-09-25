class TrieNode
{
public:
    char character;
    map<char,TrieNode*> children;
    bool terminate=false;
    
    TrieNode()
    {
        character='-';
    }
    
    TrieNode(char c)
    {
        character=c;
    }

    TrieNode* getChild(char c)
    {
        return children[c];
    }
    
    void setTerminate(bool t)
    {
        terminate=t;
    }
    
    void addWord(string word)
    {
        if(word=="")
            return;
        
        char c=word.at(0);
        
        TrieNode* child=getChild(c);
        
        if(child==NULL)
        {
            child=new TrieNode(c);
            children[c]=child;
        }
        
        if(word.size()==1)
            child->setTerminate(true);
        else
            child->addWord(word.substr(1,word.size()-1));
    }
};

class Trie {
public:
    TrieNode* root;
    
    Trie() {
        root=new TrieNode();
    }
    
    void insert(string word) {
        root->addWord(word);
    }
    
    bool search(string word, TrieNode* node)
    {
        if(word=="")
            return node->terminate;
        
        char c=word.at(0);
        
        TrieNode* child=node->getChild(c);
        
        if(child==NULL)
            return false;
        else
            return search(word.substr(1,word.size()-1),child);
    }
    
    bool search(string word) {
        return search(word,root);   
    }
    
    bool startsWith(string prefix, TrieNode* node)
    {
        if(prefix=="")
            return true;
        
        char c=prefix.at(0);
        
        TrieNode* child=node->getChild(c);
        
        if(child==NULL)
            return false;
        else
            return startsWith(prefix.substr(1,prefix.size()-1),child);
    }
    
    bool startsWith(string prefix) {
        return startsWith(prefix,root);   
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */