/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        if(head.next==null)
            return new TreeNode(head.val);
        
        TreeNode subtree=sortedListToBST(head.next);
        
        subtree=addToTree(head.val,subtree);
        
        return subtree;
        
    }
    
    private TreeNode rotateRight(TreeNode tree)
    {
        TreeNode x=tree.left;
        
        tree.left=x.right;
        x.right=tree;
        
        return x;
    }
    
    private TreeNode addToTree(int a, TreeNode tree)
    {
        if(tree==null)
            return new TreeNode(a);
        
        while(leftDepth(tree)>rightDepth(tree))
        {
            tree=rotateRight(tree);
        }
            
        if(a<tree.val)
        {
            tree.left=addToTree(a,tree.left);
        }
        else if(a>tree.val)
        {
            tree.right=addToTree(a,tree.right);
        }
        
        return tree;
    }
    
    private int leftDepth(TreeNode tree)
    {
        if(tree==null)
            return 0;
        if(tree.left==null)
            return 0;
        return 1+Math.max(leftDepth(tree.left),rightDepth(tree.left));
    }
    
    private int rightDepth(TreeNode tree)
    {
        if(tree==null)
            return 0;
        if(tree.right==null)
            return 0;
        return 1+Math.max(leftDepth(tree.right),rightDepth(tree.right));
    }
}