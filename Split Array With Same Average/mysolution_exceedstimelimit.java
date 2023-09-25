class Solution {
    
    int n;
    
    private boolean backTrack(int[] nums, int index, int sumA, int sumB, int numA, int numB)
    {
        if(index==n)
        {
            //System.out.println(sumA+":"+numA+":"+sumB+":"+numB);
            if(numA==0||numB==0||(double)sumA/numA!=(double)sumB/numB)
                return false;
            else
                return true;
        }
        
        if(backTrack(nums,index+1,sumA+nums[index],sumB,numA+1,numB))
            return true;
        else if(backTrack(nums,index+1,sumA,sumB+nums[index],numA,numB+1))
            return true;
        else
            return false;
    }
    
    public boolean splitArraySameAverage(int[] nums) {
        
        n=nums.length;
        
        return backTrack(nums,0,0,0,0,0);
    }
}