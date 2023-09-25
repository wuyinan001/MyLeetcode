# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:      
    def __init__(self):
        self.dict={}
    
    def count(self,root):
        if root==None:
            return
        
        if root.val in self.dict:
            self.dict[root.val]+=1
        else:
            self.dict[root.val]=1
        
        self.count(root.left)
        self.count(root.right)
        
        
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        self.count(root)
        ans=[]
        
        max1=0
        
        for i in self.dict.values():
            max1=max(max1,i)
        
        for key in self.dict:
            if self.dict[key]==max1:
                ans.append(key)
        
        return ans