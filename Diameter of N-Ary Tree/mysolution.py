"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []
"""

class Solution:
    def __init__(self):
        self.ans=0
        
    def dfs(self,node):
        if node==None:
            return 0
        
        paths=[0,0]
        
        for c in node.children:
            curr=self.dfs(c)
            if c!=None:
                curr+=1
            
            paths.append(curr)
        
        paths.sort(reverse=True)
        
        self.ans=max(self.ans,paths[0]+paths[1])
        
        return paths[0]
        
    def diameter(self, root: 'Node') -> int:
        """
        :type root: 'Node'
        :rtype: int
        """
        self.dfs(root)

        return self.ans