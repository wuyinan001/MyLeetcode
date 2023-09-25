# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans=[]
        
        if root==None:
            return ans
        
        dict1={0:[root.val]}
        queue=[(root,0)]
        
        while queue:
            pair=queue.pop(0)
            if pair[0].left:
                queue.append((pair[0].left,pair[1]-1))
                if pair[1]-1 not in dict1:
                    dict1[pair[1]-1]=[]
                dict1[pair[1]-1].append(pair[0].left.val)
            
            if pair[0].right:
                queue.append((pair[0].right,pair[1]+1))
                if pair[1]+1 not in dict1:
                    dict1[pair[1]+1]=[]
                dict1[pair[1]+1].append(pair[0].right.val)
        
        list_keys=list(dict1.keys())
        list_keys.sort()
        
        for key in list_keys:
            ans.append(dict1[key])
        
        return ans