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
    public int closestValue(TreeNode root, double target) {
        
        if(root.val==target)
            return root.val;
        
        if(target<root.val&&root.left==null)
            return root.val;
        
        if(target>root.val&&root.right==null)
            return root.val;
        
        if(target<root.val)
        {
            int left=closestValue(root.left,target);
            
            if(Math.abs(target-left)<Math.abs(target-root.val))
                return left;
            else
                return root.val;
        }
        
        int right=closestValue(root.right,target);
        
        if(Math.abs(target-right)<Math.abs(target-root.val))
            return right;
        else
            return root.val;

    }
}