class TrieNode:
    def __init__(self,char=None):
        self.char=char
        self.children={}
        self.terminate=False
        
    def getChild(self,char):
        return self.children.get(char,None)
    
    def setTerminate(self,t):
        self.terminate=t
        
    def addWord(self,word):
        if word==None or word=="":
            return
        
        c=word[0]
        child=self.getChild(c)
        
        if child==None:
            child=TrieNode(c)
            self.children[c]=child
        
        if len(word)==1:
            child.setTerminate(True)
        else:
            child.addWord(word[1:])
    
    # Find all sentences under current node
    def findWord(self):
        ans=[]
        
        if self.terminate:
            ans.append("")
        
        for child in self.children.values():
            s=child.char
            for str1 in child.findWord():
                ans.append(s+str1)
        
        return ans
    
class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        self.root=TrieNode()
        self.map={}
        self.prefix=""
        self.curr=self.root
        self.exist=True
        
        for i in range(len(sentences)):
            self.map[sentences[i]]=times[i]
            self.root.addWord(sentences[i])
    

    def input(self, c: str) -> List[str]:
        if c=="#":
            new_sentence=self.prefix
            self.prefix=""
            self.curr=self.root
            # The current input prefix exists in the Trie or not
            self.exist=True
            
            if new_sentence in self.map:
                self.map[new_sentence]+=1
            else:
                self.map[new_sentence]=1
                self.root.addWord(new_sentence)
            
            return []
        else:
            self.prefix=self.prefix+c
            ans=[]
            
            if self.exist and c in self.curr.children:
                self.curr=self.curr.children[c]
                str_list=self.curr.findWord()
                for str1 in str_list:
                    ans.append(self.prefix+str1)
                
                # If the map[s] is different, sort by map[s] higher first;
                # If the map[s] is the same, sort by s by ASCII-code order
                ans.sort(key=lambda x:(-self.map[x],x))
                
                if len(ans)>3:
                    return ans[:3]
                else:
                    return ans
            else:
                self.exist=False
                return ans
                
            


# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)