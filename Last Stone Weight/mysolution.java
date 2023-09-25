class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        
        if(n==1)
            return stones[0];
        
        if(n==2&&stones[0]==stones[1])
            return 0;
        
        int[] substones;
        
        Arrays.sort(stones);
        
        int diff=stones[n-1]-stones[n-2];
        
        if(diff==0)
        {
            substones=new int[n-2];
            
            for(int i=0;i<n-2;i++)
            {
                substones[i]=stones[i];
            }
        }
        else
        {
            substones=new int[n-1];
            boolean put_new=false;
        
            for(int i=0;i<n-2;i++)
            {
                substones[i]=stones[i];
            }
            
            substones[n-2]=diff;
        }
        
        
        return lastStoneWeight(substones);
    }
}