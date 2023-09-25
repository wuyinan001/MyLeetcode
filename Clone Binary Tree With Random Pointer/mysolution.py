# Definition for Node.
# class Node:
#     def __init__(self, val=0, left=None, right=None, random=None):
#         self.val = val
#         self.left = left
#         self.right = right
#         self.random = random

class NodeCopy:
    def __init__(self, val=0, left=None, right=None, random=None):
        self.val = val
        self.left = left
        self.right = right
        self.random = random

class Solution:
    def copyRandomBinaryTree(self, root: 'Optional[Node]') -> 'Optional[NodeCopy]':
        if root==None:
            return None
        
        map1={None:None}
        
        queue=[root]
        
        while queue:
            curr=queue.pop(0)
            map1[curr]=NodeCopy(curr.val)
            
            if curr.left:
                queue.append(curr.left)
            
            if curr.right:
                queue.append(curr.right)
        
        queue=[root]
        
        while queue:
            curr=queue.pop(0)
            
            map1[curr].random=map1[curr.random]
            
            if curr.left:
                map1[curr].left=map1[curr.left]
                queue.append(curr.left)
                
            if curr.right:
                map1[curr].right=map1[curr.right]
                queue.append(curr.right)
                
        return map1[root]