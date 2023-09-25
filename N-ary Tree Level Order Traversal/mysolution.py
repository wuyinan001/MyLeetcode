"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root==None:
            return []

        ans=[]
        queue=[root]

        while queue:
            size=len(queue)
            list1=[]
            for i in range(size):
                curr=queue.pop(0)
                list1.append(curr.val)
                for child in curr.children:
                    queue.append(child)
            ans.append(list1)
        
        return ans