/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private List<Integer> preOrder(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        if(root==null)
            return ans;
        
        ans.add(root.val);
        ans.addAll(preOrder(root.left));
        ans.addAll(preOrder(root.right));
        
        return ans;
    }
    
    private List<Integer> inOrder(TreeNode root)
    {
        List<Integer> ans=new ArrayList();
        if(root==null)
            return ans;
        
        ans.addAll(inOrder(root.left));
        ans.add(root.val);
        ans.addAll(inOrder(root.right));
        
        return ans;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        List<Integer> list1=preOrder(root);
        List<Integer> list2=inOrder(root);
        
        if(list1.size()==0)
            return "";
        
        StringBuilder sb=new StringBuilder();
        
        for(int i:list1)
            sb.append(i+",");
        
        sb.append("#");
        
        for(int i:list2)
            sb.append(i+",");
        
        return sb.toString();
    }
    
    private TreeNode createTree(int[] preOrder, int[] inOrder)
    {
        if(preOrder.length==0)
            return null;
        
        TreeNode root=new TreeNode(preOrder[0]);
        
        int index=0;
        
        for(int i=0;i<inOrder.length;i++)
            if(inOrder[i]==root.val)
            {
                index=i;
                break;
            }
        
        int leftNodes=index, rightNodes=preOrder.length-1-index;
        
        int[] leftPreOrder=new int[leftNodes];
        int[] leftInOrder=new int[leftNodes];
        int[] rightPreOrder=new int[rightNodes];
        int[] rightInOrder=new int[rightNodes];
        
        for(int i=1;i<=leftNodes;i++)
            leftPreOrder[i-1]=preOrder[i];
        
        for(int i=0;i<leftNodes;i++)
            leftInOrder[i]=inOrder[i];
        
        for(int i=leftNodes+1;i<preOrder.length;i++)
            rightPreOrder[i-leftNodes-1]=preOrder[i];
        
        for(int i=index+1;i<inOrder.length;i++)
            rightInOrder[i-leftNodes-1]=inOrder[i];
        
        root.left=createTree(leftPreOrder,leftInOrder);
        root.right=createTree(rightPreOrder,rightInOrder);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        System.out.println(data);
        if(data.equals(""))
            return null;
        
        String[] strs=data.split("#");
        
        String[] preOrderStrs=strs[0].split(",");
        String[] inOrderStrs=strs[1].split(",");
        
        int[] preOrder=new int[preOrderStrs.length];
        int[] inOrder=new int[inOrderStrs.length];
        
        for(int i=0;i<preOrder.length;i++)
            preOrder[i]=Integer.parseInt(preOrderStrs[i]);
        
        for(int i=0;i<inOrder.length;i++)
            inOrder[i]=Integer.parseInt(inOrderStrs[i]);
        
        TreeNode ans=createTree(preOrder,inOrder);
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));