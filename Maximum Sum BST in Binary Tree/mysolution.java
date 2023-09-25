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
    
    int max=0;
    
    // 1: if BST or not; 2: sum of root; 3: min of root; 4: max of root
    private int[] isBST(TreeNode root)
    {
        if(root==null)
            return new int[]{1,0,0,0};
        
        if(root.left==null&&root.right==null)
        {
            max=Math.max(max,root.val);
            return new int[]{1,root.val,root.val,root.val};
        }
        
        int bst=0, sum=root.val, min_val=root.val, max_val=root.val;
        
        if(root.left==null)
        {
            int[] ans2=isBST(root.right);
            if(ans2[0]==1&&ans2[2]>root.val)
            {
                bst=1;
                max_val=ans2[3];
                sum=sum+ans2[1];
                max=Math.max(max,sum);
            }
            
            return new int[]{bst,sum,min_val,max_val};
        }
        else if(root.right==null)
        {
            int[] ans1=isBST(root.left);
            if(ans1[0]==1&&ans1[3]<root.val)
            {
                bst=1;
                min_val=ans1[2];
                sum=sum+ans1[1];
                max=Math.max(max,sum);
            }
            
            return new int[]{bst,sum,min_val,max_val};
        }
        
        
        int[] ans1=isBST(root.left);
        int[] ans2=isBST(root.right);
        
        if(ans1[0]==1&&ans1[3]<root.val&&ans2[0]==1&&ans2[2]>root.val)
        {
            bst=1;
            min_val=ans1[2];
            max_val=ans2[3];
            sum=sum+ans1[1]+ans2[1];
            max=Math.max(max,sum);
        }
        
        
        return new int[]{bst,sum,min_val,max_val};
    }
    

    
    public int maxSumBST(TreeNode root) {
        
        isBST(root);
        
        return max;
    }
}