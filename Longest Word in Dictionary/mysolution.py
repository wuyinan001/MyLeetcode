class Solution:
    def longestWord(self, words: List[str]) -> str:
        dict1={}
        list1=[]
        maxLen=0
        words.sort()

        for w in words:
            if len(w)==1:
                dict1[w]=True
            elif w[:-1] in dict1 and dict1[w[:-1]]:
                dict1[w]=True
            
            if w in dict1 and dict1[w] and maxLen<=len(w):
                #print(w)
                if maxLen<len(w):
                    maxLen=len(w)
                    list1.clear()
                list1.append(w)

        list1.sort()

        if len(list1)==0:
            return ""
    
        return list1[0]