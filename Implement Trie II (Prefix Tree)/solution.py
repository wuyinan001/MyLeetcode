class TrieNode:
    def __init__(self,char=None):
        self.children={}
        self.cnt=0
        self.pnt=0
        self.char=char
    
    def getChild(self,char):
        if char in self.children:
            return self.children[char]
        return None

class Trie:
    def __init__(self):
        self.root=TrieNode()

    def insert(self, word: str) -> None:
        print("insert")
        curr=self.root

        for char in word:
            child=curr.getChild(char)
            if child==None:
                child=TrieNode(char)
                curr.children[char]=child
            curr=child
            curr.pnt+=1
        curr.cnt+=1

        #self.printTrie()
    
    def printTrie(self):
        queue=[self.root]

        while queue:
            size=len(queue)
            print("*****************************")
            for _ in range(size):
                curr=queue.pop(0)
                print(curr.char,":",curr.pnt,":",curr.cnt,";")
                for child in curr.children.values():
                    queue.append(child)

    def countWordsEqualTo(self, word: str) -> int:
        curr=self.root
        for char in word:
            if char not in curr.children:
                return 0
            curr=curr.getChild(char)
        return curr.cnt

    def countWordsStartingWith(self, prefix: str) -> int:
        curr=self.root
        for char in prefix:
            if char not in curr.children:
                return 0
            curr=curr.getChild(char)
        return curr.pnt

    def erase(self, word: str) -> None:
        curr=self.root
        if self.countWordsEqualTo(word)==0:
            return

        for char in word:
            curr=curr.getChild(char)
            curr.pnt-=1
        curr.cnt-=1


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.countWordsEqualTo(word)
# param_3 = obj.countWordsStartingWith(prefix)
# obj.erase(word)