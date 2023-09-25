class TrieNode{
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
        
        char c=word[0];
        
        TrieNode* child=getChild(c);
        
        if(!child)
        {
            child=new TrieNode(c);
            children[c]=child;
        }
        
        if(word.size()==1)
        {
            child->setTerminate(true);
        }
        else
        {
            child->addWord(word.substr(1,word.size()-1));
        }
    }
    
    vector<string> find()
    {
        vector<string> ans;
        
        if(terminate)
            ans.push_back("");
        
        for(auto i:children)
        {
            vector<string> list=i.second->find();
            for(string t:list)
            {
                ans.push_back(i.first+t);
            }
        }
        
        return ans;
    }
};

class Compare
{
public:
    map<string,int> freq;
    
    Compare()
    {
        
    }
    
    Compare(map<string,int>& freq)
    {
        this->freq=freq;
    }
    
    bool operator() (const string& s1, const string& s2)
    {
        if(freq[s1]==freq[s2])
            return s1<s2;
        else
            return freq[s1]>freq[s2];
    }
};

class AutocompleteSystem {
public:
    TrieNode root;
    map<string,int> freq;
    string prefix;
    TrieNode* node;

    AutocompleteSystem(vector<string>& sentences, vector<int>& times) {
        int n=sentences.size();
        
        for(int i=0;i<n;i++)
        {
            root.addWord(sentences[i]);
            freq[sentences[i]]=times[i];
        }
        
        prefix="";
        node=&root;
    }
    
    vector<string> input(char c) {
        if(c=='#')
        {
            if(freq.find(prefix)==freq.end())
            {
                freq[prefix]=1;
                root.addWord(prefix);
            }
            else
                freq[prefix]++;
            
            prefix="";
            node=&root;
            
            return {};
        }
        
        prefix=prefix+c;
        
        if(node==NULL)
            return {};
        
        node=node->getChild(c);
        
        if(node==NULL)
            return {};
        
        vector<string> list=node->find();
        
        vector<string> ans;
        
        for(string s:list)
        {
            ans.push_back(prefix+s);
        }
        
        sort(ans.begin(),ans.end(),Compare(freq));
        
        if(ans.size()<=3)
            return ans;
        else
            return vector<string>{ans.begin(),ans.begin()+3};
    }
};

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem* obj = new AutocompleteSystem(sentences, times);
 * vector<string> param_1 = obj->input(c);
 */