/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */
class TreeNode extends Node
{
    private TreeNode left;
    private TreeNode right;
    private String value;
    
    public TreeNode(TreeNode left, TreeNode right, String value)
    {
        this.left=left;
        this.right=right;
        this.value=value;
    }
    
    public int evaluate()
    {
        
        if(left==null)
            return Integer.parseInt(value);
        
        switch(value)
        {
            case "+": 
                return left.evaluate()+right.evaluate();
            case "-":
                return left.evaluate()-right.evaluate();
            case "*": 
                return left.evaluate()*right.evaluate();
            case "/":
                return left.evaluate()/right.evaluate();
            default:
                return Integer.parseInt(value);
        }
    }
}

class TreeBuilder {
    Node buildTree(String[] postfix) {
        
        TreeNode root=null;
        
        Stack<TreeNode> stack=new Stack();
        
        for(String s:postfix)
        {
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))
            {
                TreeNode right=stack.pop();
                TreeNode left=stack.pop();
                
                root=new TreeNode(left,right,s);
            }
            else
            {
                root=new TreeNode(null,null,s);
            }
            
            stack.push(root);
        }
        
        return root;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */