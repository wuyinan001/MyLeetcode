"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node==None:
            return None
        
        queue=[]
        queue.append(node)
        
        map1={}
        map1[node]=Node(node.val)
        
        while queue:
            curr=queue.pop(0)
            
            for neighbor in curr.neighbors:
                if neighbor not in map1.keys():
                    queue.append(neighbor)
                    map1[neighbor]=Node(neighbor.val)
                
                map1[curr].neighbors.append(map1[neighbor])
        
        return map1[node]