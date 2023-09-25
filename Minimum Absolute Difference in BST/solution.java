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
    public int getMinimumDifference(TreeNode root) {
        
        if(root.left==null&&root.right==null)
            return Integer.MAX_VALUE;
        
        int min=Integer.MAX_VALUE;
        
        if(root.left==null)
        {
            TreeNode a=root.right;
            
            while(a.left!=null)
                a=a.left;
            
            min=a.val-root.val;
            
            return Math.min(min,getMinimumDifference(root.right));
        }
        else if(root.right==null)
        {
            TreeNode a=root.left;
            
            while(a.right!=null)
                a=a.right;
            
            min=root.val-a.val;
            
            return Math.min(min,getMinimumDifference(root.left));
        }
        else
        {
            TreeNode a=root.left;
            
            while(a.right!=null)
                a=a.right;
            
            min=root.val-a.val;
            
            a=root.right;
            
            while(a.left!=null)
                a=a.left;
            
            min=Math.min(min,a.val-root.val);
            
            return Math.min(min,Math.min(getMinimumDifference(root.right),getMinimumDifference(root.left)));
        }
    }
}