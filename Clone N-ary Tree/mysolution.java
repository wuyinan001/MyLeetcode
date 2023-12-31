class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        
        if(root==null)
            return null;
        
        Node copy=new Node(root.val);
        
        for(Node t:root.children)
        {
            copy.children.add(cloneTree(t));
        }
        
        return copy;
    }
}