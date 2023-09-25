# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans=[]
    
    def dfs(self,u,path):
        path=path+"->"+str(u.val)
        if u.left==None and u.right==None:
            self.ans.append(path[2:])
            return
        
        if u.left:
            self.dfs(u.left,path)
        
        if u.right:
            self.dfs(u.right,path)
            
        
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if root==None:
            return []
        self.dfs(root,"")
        return self.ans