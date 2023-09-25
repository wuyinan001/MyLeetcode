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
    
    private boolean isLeaf(TreeNode root)
    {
        if(root==null)
            return false;
        
        if(root.left==null&&root.right==null)
            return true;
        else
            return false;
    }
    
    private List<Integer> leftBound(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        
        if(root.left==null)
            return ans;
        
        TreeNode curr=root.left;
        
        while(!isLeaf(curr))
        {
            ans.add(curr.val);
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
        
        return ans;
    }
    
    private List<Integer> rightBound(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        
        if(root.right==null)
            return ans;
        
        TreeNode curr=root.right;
        Stack<Integer> stack=new Stack();
        
        while(!isLeaf(curr))
        {
            stack.add(curr.val);
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }
        
        while(!stack.isEmpty())
            ans.add(stack.pop());
        
        return ans;
    }
    
    private List<Integer> leafBound(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        if(isLeaf(root))
        {
            ans.add(root.val);
            return ans;
        }
        
        ans.addAll(leafBound(root.left));
        ans.addAll(leafBound(root.right));
        
        return ans;
    }
    
    
    private void print(List<Integer> list)
    {
        for(int i:list)
            System.out.print(i+" ");
        System.out.println();
    }
    
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        if(isLeaf(root))
        {
            ans.add(root.val);
            return ans;
        }
        
        /*
        System.out.print("leftbound: ");
        print(leftBound(root));
        System.out.print("leafbound: ");
        print(leafBound(root));
        System.out.print("rightbound: ");
        print(rightBound(root));
        */
        
        ans.add(root.val);
        ans.addAll(leftBound(root));
        ans.addAll(leafBound(root));
        ans.addAll(rightBound(root));
        
        return ans;
    }
}