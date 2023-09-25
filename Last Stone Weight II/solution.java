class Solution {
    
    // This problem can be interpretted as if partition the stones into two group, what is the minimum diff between the sum of these
    // two groups?
    
    // dp(stones,index,sumL,sumR,memo) returns the minimum diff when there are sumL stones on the left and sumR stones on the right
    // And we are currently at index position
     
    private int dp(int[] stones, int index, int sumL, int sumR, Integer[][] memo)
    {
        if(index==stones.length)
            return Math.abs(sumL-sumR);
        
        if(memo[index][sumL]!=null)
            return memo[index][sumL];
        
        memo[index][sumL]=Math.min(dp(stones,index+1,sumL+stones[index],sumR,memo),dp(stones,index+1,sumL,sumR+stones[index],memo));
        
        return memo[index][sumL];
    }
    
    public int lastStoneWeightII(int[] stones) {
        
        int n=stones.length;
        
        int sum=0;
        
        for(int i:stones)
            sum+=i;
        
        Integer[][] memo=new Integer[n][sum+1];
        
        return dp(stones,0,0,0,memo);
    }
}