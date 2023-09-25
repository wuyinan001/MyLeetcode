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
    
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        
        List<Integer> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        if(root.left!=null&&root.right!=null)
        {
            ans.addAll(getLonelyNodes(root.left));
            ans.addAll(getLonelyNodes(root.right));
        }
        else if(root.left!=null)
        {
            ans.add(root.left.val);
            ans.addAll(getLonelyNodes(root.left));
        }
        else if(root.right!=null)
        {
            ans.add(root.right.val);
            ans.addAll(getLonelyNodes(root.right));
        }
        
        return ans;
    }
}