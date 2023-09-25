class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n=mat.length, m=mat[0].length;
        
        for(int diff=m-1;diff>=-(n-1);diff--)
        {
            List<Integer> list=new ArrayList();
            
            for(int i=Math.max(0,-diff);(i+diff<m)&&(i<n);i++)
            {
                list.add(mat[i][i+diff]);
            }
            
            Collections.sort(list);
            int k=0;
            for(int i=Math.max(0,-diff);(i+diff<m)&&(i<n);i++)
            {
                mat[i][i+diff]=list.get(k++);
            }
        }
        
        return mat;
    }
}