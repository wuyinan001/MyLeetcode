class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        ans=0
        
        while True:
            for i in range(len(tickets)):
                if tickets[i]>0:
                    ans+=1
                    tickets[i]-=1
                if tickets[k]==0:
                    return ans
        
        return -1