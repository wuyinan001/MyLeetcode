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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return null;
        
        TreeNode root=new TreeNode(0);
        
        root=sortedArrayToBST(root,nums,0,n-1);

        return root;
    }
    
    private static TreeNode sortedArrayToBST(TreeNode a, int nums[], int lo, int hi)
    {
        if(lo>hi)
            return null;
        
        int mid=lo+(hi-lo)/2;
        
        if(a==null)
            a=new TreeNode(nums[mid]);
        else
            a.val=nums[mid];
        
        a.left=sortedArrayToBST(a.left,nums,lo,mid-1);
        a.right=sortedArrayToBST(a.right,nums,mid+1,hi);
        
        return a;
    }
    
    
    private static void add(TreeNode a, int n)
    {
        int cmp=n-a.val;
        
        if(cmp<0)
        {
            if(a.left==null)
                a.left=new TreeNode(n);
            else
                add(a.left,n);
        }
        else if(cmp>0)
        {
            if(a.right==null)
                a.right=new TreeNode(n);
            else
                add(a.right,n);
        }
        else
            a.val=n;
    }
}