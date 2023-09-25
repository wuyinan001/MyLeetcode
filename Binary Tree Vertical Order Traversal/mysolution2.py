# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return []
        
        queue=[(root,0)]
        
        dict1={}
        
        while queue:
            curr=queue.pop(0)
            
            if curr[1] not in dict1:
                dict1[curr[1]]=[]
                
            dict1[curr[1]].append(curr[0].val)
                
            if curr[0].left:
                queue.append((curr[0].left,curr[1]-1))
                
            if curr[0].right:
                queue.append((curr[0].right,curr[1]+1))
            
        keylist=list(dict1.keys())
        keylist.sort()
        
        ans=[]
        
        for key in keylist:
            ans.append(dict1[key])
        
        return ans