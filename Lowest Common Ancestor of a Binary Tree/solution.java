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
    
    TreeNode ans=null;
    
    // Return how many matching nodes found under root
    private int helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
            return 0;
        
        int mid=0, left=0, right=0;
        
        if(root==p||root==q)
            mid=1;
        
        if(helper(root.left,p,q)==1)
            left=1;
        
        if(helper(root.right,p,q)==1)
            right=1;
        
        if(mid+left+right>=2)
            ans=root;
            
        
        return mid+left+right;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        helper(root,p,q);
        
        return ans;
    }
}