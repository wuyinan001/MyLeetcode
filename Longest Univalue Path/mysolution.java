/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.left==null&&root.right==null)
            return 0;
        
        if(root.left==null)
        {
            return Math.max(maxPathRoot(root),longestUnivaluePath(root.right));
        }
        
        if(root.right==null)
        {
            return Math.max(maxPathRoot(root),longestUnivaluePath(root.left));
        }
        
        //System.out.println("Root value: "+root.val);
        //System.out.println("MaxPathRoot: "+maxPathRoot(root));
        //System.out.println("longest path left: "+longestUnivaluePath(root.left));
        //System.out.println("longest path right: "+longestUnivaluePath(root.right));
        
        if(root.val==root.left.val&&root.val==root.right.val)    
            return Math.max(maxPathRoot(root.left)+maxPathRoot(root.right)+2,
                            Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right)));
            
        return Math.max(maxPathRoot(root),Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right)));
    }
    
    private int maxPathRoot(TreeNode root)
    {
        if(root==null)
            return 0;
        
        if(root.left==null&&root.right==null)
            return 0;
        
        if(root.left==null)
        {
            if(root.right.val==root.val)
                return 1+maxPathRoot(root.right);
            else
                return 0;
        }
        
        if(root.right==null)
        {
            if(root.left.val==root.val)
                return 1+maxPathRoot(root.left);
            else
                return 0;
        }
        
        int left=0,right=0;
        
        if(root.left.val==root.val)
            left=1+maxPathRoot(root.left);
        
        if(root.right.val==root.val)
            right=1+maxPathRoot(root.right);
        
        return Math.max(left,right);
    }
}