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
    
    private List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans=new ArrayList<>();
        
        if(root==null)
            return ans;
        
        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        
        return ans;
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> ans=inorderTraversal(root);
        
        return ans.get(k-1);
        
    }
}