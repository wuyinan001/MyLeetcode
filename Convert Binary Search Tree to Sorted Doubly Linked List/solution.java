/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    Node first=null, prev=null;
    
    private void helper(Node root)
    {
        if(root!=null)
        {
            helper(root.left);
            
            if(prev!=null)
            {
                prev.right=root;
                root.left=prev;
            }
            else
            {
                first=root;
            }
            
            prev=root;
            helper(root.right);
            
        }
        
    }
    
    
    public Node treeToDoublyList(Node root) {
        
        if(root==null)
            return null;
        
        helper(root);
        
        first.left=prev;
        prev.right=first;
        
        return first;
    }
}