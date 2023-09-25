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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0)
            return null;
        
        TreeNode root=new TreeNode(preorder[0]);
        
        int L=0,R=0;
        
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==root.val)
            {
                L=i;
                R=inorder.length-i-1;
                break;
            }
        
        int[] preorder_L=new int[L];
        int[] inorder_L=new int[L];
        int[] preorder_R=new int[R];
        int[] inorder_R=new int[R];
        
        for(int i=0;i<inorder.length;i++)
        {
            if(i<L)
                inorder_L[i]=inorder[i];
            else if(i>L)
                inorder_R[i-L-1]=inorder[i];
        }
        
        for(int i=1;i<preorder.length;i++)
        {
            if(i<=L)
                preorder_L[i-1]=preorder[i];
            else
                preorder_R[i-1-L]=preorder[i];
        }
        
        root.left=buildTree(preorder_L,inorder_L);
        root.right=buildTree(preorder_R,inorder_R);
        
        return root;
    }
}