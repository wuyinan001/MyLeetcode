# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.set1=set([])
        self.ans=[]
    
    def dfs(self,node):
        if node!=None:
            node.left=self.dfs(node.left)
            node.right=self.dfs(node.right)
            
            if node.val in self.set1:
                if node.left!=None:
                    self.ans.append(node.left)
                if node.right!=None:
                    self.ans.append(node.right)
                return None
            else:
                return node
    
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        for i in to_delete:
            self.set1.add(i)
        
        new_root=self.dfs(root)
        
        if new_root!=None:
            self.ans.append(new_root)
            
        return self.ans