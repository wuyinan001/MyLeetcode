class Solution {
    
    int n,sum=0;
    boolean ans=false;
    
    private void backTrack(int[] nums, int side1, int side2, int side3, int side4, int index)
    {
        if(index==n)
        {
            if((side1==side2)&&(side2==side3)&&(side3==side4))
            {
                ans=true;
            }
                
            return;
        }
        
        if(side1>sum/4||side2>sum/4||side3>sum/4||side4>sum/4)
            return;
        
        backTrack(nums,side1+nums[index],side2,side3,side4,index+1);
        backTrack(nums,side1,side2+nums[index],side3,side4,index+1);
        backTrack(nums,side1,side2,side3+nums[index],side4,index+1);
        backTrack(nums,side1,side2,side3,side4+nums[index],index+1);
    }
    
    public boolean makesquare(int[] matchsticks) {
        
        n=matchsticks.length;
        
        for(int i:matchsticks)
            sum+=i;
        
        if(sum%4!=0)
            return false;
        
        backTrack(matchsticks,0,0,0,0,0);
        
        return ans;
    }
}