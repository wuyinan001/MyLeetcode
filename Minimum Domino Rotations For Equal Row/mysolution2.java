class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len=A.length;
        List<Integer> rotations=new ArrayList<>();
        int[] cand={A[0],B[0]};
        
        for(int i:cand)
        {
            int j,sumA=0,sumB=0;
            for(j=0;j<len;j++)
            {
                if(A[j]!=i&&B[j]!=i)
                    break;
                if(A[j]==i&&B[j]!=i)
                    sumB++;
                if(A[j]!=i&&B[j]==i)
                    sumA++;
            }
            
            if(j==len)
            {
                //System.out.println("i: "+i);
                //System.out.println("sumA: "+i);
                //System.out.println("sumB: "+i);
                rotations.add(Math.min(sumA,sumB));
            }
                
        }
        
        if(rotations.isEmpty())
            return -1;
        
        int min=rotations.get(0);
        
        for(int i=1;i<rotations.size();i++)
            if(min>rotations.get(i))
                min=rotations.get(i);
        
        return min;
        
    }
        
}