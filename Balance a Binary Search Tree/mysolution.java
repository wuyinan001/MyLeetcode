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
    
    private List<Integer> toList(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        ans.addAll(toList(root.left));
        ans.add(root.val);
        ans.addAll(toList(root.right));
        
        return ans;
    }
    
    private TreeNode toBST(List<Integer> list, int lo, int hi)
    {
        if(lo>hi)
            return null;
        
        int mid=lo+(hi-lo)/2;
        
        TreeNode root=new TreeNode(list.get(mid));
        
        root.left=toBST(list,lo,mid-1);
        root.right=toBST(list,mid+1,hi);
        
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> list=toList(root);
        
        return toBST(list,0,list.size()-1);
    }
}