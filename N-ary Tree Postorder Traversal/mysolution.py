"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        ans=[]
        
        if root==None:
            return ans
        
        for node in root.children:
            ans.extend(self.postorder(node))
        
        ans.append(root.val)
        
        return ans