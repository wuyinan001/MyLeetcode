# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root==None:
            return "null,"
        
        ans=""
        ans+=str(root.val)+","
        ans+=self.serialize(root.left)
        ans+=self.serialize(root.right)
        
        return ans
        
    def deserialize2(self,list1):
        if list1[0]=="null":
            list1.pop(0)
            return None
        
        node=TreeNode(int(list1[0]))
        list1.pop(0)
        node.left=self.deserialize2(list1)
        node.right=self.deserialize2(list1)
        
        return node
    
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        list1=data.split(",")
        return self.deserialize2(list1)
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))