"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if root==None:
            return 0
        
        max1=0

        for child in root.children:
            max1=max(max1,self.maxDepth(child))

        return 1+max1