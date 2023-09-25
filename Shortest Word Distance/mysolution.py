class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        dict1={}
        for i in range(len(wordsDict)):
            if wordsDict[i] not in dict1:
                dict1[wordsDict[i]]=[]
            dict1[wordsDict[i]].append(i)
        
        list1=dict1[word1]
        list2=dict1[word2]

        ans=float('inf')

        for i in range(len(list1)):
            for j in range(len(list2)):
                ans=min(ans,abs(list1[i]-list2[j]))
            
        return ans