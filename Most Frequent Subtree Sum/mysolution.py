# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map={}
        
    def dfs(self,node):
        if node==None:
            return 0
        
        left=self.dfs(node.left)
        right=self.dfs(node.right)
        
        ans=left+right+node.val
        self.map[ans]=self.map.get(ans,0)+1
        
        return ans
        
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root)
        keys=list(self.map.keys())
        
        keys.sort(key=lambda x:-self.map[x])
        
        ans=[]
        n=len(keys)
        for i in range(n):
            ans.append(keys[i])
            if i<n-1 and self.map[keys[i+1]]<self.map[keys[i]]:
                break
        
        return ans