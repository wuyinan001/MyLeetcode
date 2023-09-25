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
    
    private boolean isSametree(TreeNode s, TreeNode t)
    {
        if(s==null&&t!=null)
            return false;
        
        if(s!=null&&t==null)
            return false;
        
        if(s==null&&t==null)
            return true;
        
        if(s.val==t.val&&isSametree(s.left,t.left)&&isSametree(s.right,t.right))
            return true;
        
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s==null&&t!=null)
            return false;
        
        if(s!=null&&t==null)
            return false;
        
        if(s==null&&t==null)
            return true;
        
        if(isSubtree(s.left,t)||(isSubtree(s.right,t)||isSametree(s,t)))
            return true;
        
        return false;
    }
}