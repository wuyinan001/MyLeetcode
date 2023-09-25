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
class BSTIterator {
    
    List<Integer> list;
    int index;
    
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
    
    public BSTIterator(TreeNode root) {
        
        list=toList(root);
        index=-1;
        
    }
    
    public int next() {
        
        return list.get(++index);
    }
    
    public boolean hasNext() {
        
        return index<list.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */