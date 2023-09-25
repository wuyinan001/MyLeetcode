class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int n=seats.length
        //  left: the leftmost space if seats start at 0
        //  right: the rightmost space if seats end at 0
        //  max_gap: the max distance when the person sits between two 1's.
        int max_gap=0,left=0,right=0;
        
        int i=0;
        for(i=0;i<n;i++)
            if(seats[i]==1)
                break;
        
        left=i;
        
        for(i=n-1;i>=0;i--)
            if(seats[i]==1)
                break;
        
        right=n-1-i;
        
        int[] L=new int[n];
        
        if(seats[0]==0)
            L[0]=1;
        
        for(i=1;i<n;i++)
            if(seats[i]==0)
                L[i]=L[i-1]+1;
        
        for(i=0;i<n-1;i++)
            max_gap=Math.max(max_gap,L[i]);
        
        if(max_gap%2==0)
            max_gap=max_gap/2;
        else
            max_gap=max_gap/2+1;
        
        return Math.max(max_gap,Math.max(left,right));
        
    }
}