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
    
    Node first=null;
    Node prev=null;
    
    private void helper(Node node)
    {
        if(node==null)
            return;
        
        if(node.left==null&&first==null)
        {
            first=node;
            prev=node;
        }
        
        helper(node.left);
        
        if(prev!=node)
        {
            prev.right=node;
            node.left=prev;
            prev=node;
        }
        
        helper(node.right);
        
       
    }
    
    
    public Node treeToDoublyList(Node root) {
        
        if(root==null)
            return null;
        
        helper(root);
        
        prev.right=first;
        first.left=prev;
        
        return first;
    }
}