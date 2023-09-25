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
    
    int ans=0;
    
    // Find max root.val-child.val
    private int findMaxDiff(TreeNode root)
    {
        if(root==null)
            return 0;
        
        if(root.left==null&&root.right==null)
            return 0;
        
        if(root.left==null)
        {
            int result=Math.max(findMaxDiff(root.right),0)+root.val-root.right.val;
            ans=Math.max(ans,Math.abs(result));
            return result;
        }
        
        if(root.right==null)
        {
            int result=Math.max(findMaxDiff(root.left),0)+root.val-root.left.val;
            ans=Math.max(ans,Math.abs(result));
            return result;
        }
            
        
        int result=Math.max(Math.max(findMaxDiff(root.right),0)+root.val-root.right.val,Math.max(findMaxDiff(root.left),0)+root.val-root.left.val);
        ans=Math.max(ans,Math.abs(result));
        
        return result;
    }
    
    // Find min root.val-child.val
    private int findMinDiff(TreeNode root)
    {
        if(root==null)
            return 0;
        
        if(root.left==null&&root.right==null)
            return 0;
        
        if(root.left==null)
        {
            int result=Math.min(findMinDiff(root.right),0)+root.val-root.right.val;
            ans=Math.max(ans,Math.abs(result));
            return result;
        }
        
        if(root.right==null)
        {
            int result=Math.min(findMinDiff(root.left),0)+root.val-root.left.val;
            ans=Math.max(ans,Math.abs(result));
            return result;
        }
            
        
        int result=Math.min(Math.min(findMinDiff(root.right),0)+root.val-root.right.val,Math.min(findMinDiff(root.left),0)+root.val-root.left.val);
        ans=Math.max(ans,Math.abs(result));
        
        return result;
    }
    
    
        
    public int maxAncestorDiff(TreeNode root) {
        
        findMaxDiff(root);
        findMinDiff(root);
        
        return ans;
    }
}