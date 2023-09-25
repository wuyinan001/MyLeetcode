class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        fmax=0
        nmax=0
        dict1={}
        
        for t in tasks:
            dict1[t]=dict1.get(t,0)+1
            fmax=max(fmax,dict1[t])
        
        for key in dict1:
            if dict1[key]==fmax:
                nmax+=1
        
        return max(len(tasks),(fmax-1)*(n+1)+nmax)