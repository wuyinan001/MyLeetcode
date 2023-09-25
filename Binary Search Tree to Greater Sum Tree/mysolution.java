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
    public TreeNode bstToGst(TreeNode root) {
        
        List<TreeNode> list=reverseTraversal(root);
        
        if(list.size()<=1)
            return root;
        
        int cum=list.get(0).val;
    
        for(int i=1;i<list.size();i++)
        {
            cum=cum+list.get(i).val;
            list.get(i).val=cum;
        }
        
        return root;
    }
    
    // Put the tree nodes in the list in the order of largest node val to smallest node val
    private List<TreeNode> reverseTraversal(TreeNode root)
    {
        List<TreeNode> ans=new ArrayList<>();
        if(root==null)
            return ans;
        
        ans.addAll(reverseTraversal(root.right));
        ans.add(root);
        ans.addAll(reverseTraversal(root.left));
        
        return ans;
    }
}