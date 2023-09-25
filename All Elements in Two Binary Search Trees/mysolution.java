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
        List<Integer> list=new ArrayList();
        
        if(root==null)
            return list;
        
        list.addAll(toList(root.left));
        list.add(root.val);
        list.addAll(toList(root.right));
        
        return list;
    }
    
    private List<Integer> merge(List<Integer> list1, List<Integer> list2)
    {
        List<Integer> ans=new ArrayList();
        
        int i=0, j=0;
        int n1=list1.size(), n2=list2.size();
        
        while(i<n1&&j<n2)
        {
            if(list1.get(i)<=list2.get(j))
            {
                ans.add(list1.get(i++));
            }
            else
                ans.add(list2.get(j++));
        }
        
        while(i<n1)
        {
            ans.add(list1.get(i++));
        }
        
        while(j<n2)
        {
            ans.add(list2.get(j++));
        }
        
        return ans;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        return merge(toList(root1),toList(root2));
    }
}