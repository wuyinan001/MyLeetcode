# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def toList(self,node):
        ans=[]
        if node==None:
            return ans
        
        ans.extend(self.toList(node.left))
        ans.append(node.val)
        ans.extend(self.toList(node.right))
        
        return ans
    
    def isSorted(self,list):
        n=len(list)
        for i in range(n-1):
            if list[i+1]<=list[i]:
                return False
        return True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        list=self.toList(root)
        return self.isSorted(list)