class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        initial=sum(reward2)
        
        diff=[]
        
        for x,y in zip(reward1,reward2):
            diff.append(x-y)
            
        diff.sort(reverse=True)
        
        for i in range(k):
            initial+=diff[i]
            
        return initial