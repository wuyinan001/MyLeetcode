class Solution:
    def __init__(self):
        self.ans=0
        
    def noDup(self,s):
        set1=set([])
        for i in s:
            if i in set1:
                return False
            else:
                set1.add(i)
        
        return True
    
    
    def contains(self,set1,s):
        for i in s:
            if i in set1:
                return True
        return False
    
    def backTrack(self,arr,index,set1):
        if index==len(arr):
            self.ans=max(self.ans,len(set1))
            return
        
        self.backTrack(arr,index+1,set1)
        
        if self.noDup(arr[index]) and not self.contains(set1,arr[index]):
            for i in arr[index]:
                set1.add(i)
            self.backTrack(arr,index+1,set1)
            for i in arr[index]:
                set1.remove(i)
        
    
    def maxLength(self, arr: List[str]) -> int:
        self.backTrack(arr,0,set([]))
        return self.ans