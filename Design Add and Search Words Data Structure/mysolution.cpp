class TrieNode
{
public:
    char character='-';
    map<char,TrieNode*> children;
    bool terminate=false;
    
    TrieNode()
    {
    }
    
    TrieNode(char c)
    {
        character=c;
    }
    
    void setTerminate(bool t)
    {
        terminate=t;
    }
    
    TrieNode* getChild(char c)
    {
        return children[c];
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

class WordDictionary {
public:
    TrieNode* root;
    
    WordDictionary() {
        root=new TrieNode();    
    }
    
    void addWord(string word) {
        root->addWord(word);
    }
    
    bool search(string word, TrieNode* node)
    {        
        if(word=="")
            return node->terminate;
        
        char c=word[0];
        
        if(c=='.')
        {
            for(auto i:node->children)
                if(search(word.substr(1,word.size()-1),i.second))
                    return true;
        }
        else if(node->children.find(c)!=node->children.end())
        {
            if(search(word.substr(1,word.size()-1),node->getChild(c)))
                return true;
        }
        return false;
    }
    
    bool search(string word) {
        return search(word,root);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */