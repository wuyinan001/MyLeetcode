/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Check if p is child of t
    private boolean found(TreeNode t, TreeNode p)
    {
        if(t==null)
            return false;
        
        if(p==null)
            return  true;
        
        if(t==p||found(t.left,p)||found(t.right,p))
            return true;
        
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==p)
            return p;
        
        if(root==q)
            return q;
        
        boolean left_p=found(root.left,p), left_q=found(root.left,q);
        
        if((left_p&&!left_q)||(!left_p&&left_q))
            return root;
        
        if(left_p&&left_q)
            return lowestCommonAncestor(root.left,p,q);
        
        return lowestCommonAncestor(root.right,p,q);
    }
}