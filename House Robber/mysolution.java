class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return nums[0];
        
        // Maximum amount stolen stopped at nums[i]
        int[] rob=new int[n];
        
        rob[0]=nums[0];
        rob[1]=nums[1];
        
        int result=rob[0];
        
        if(result<rob[1])
            result=rob[1];
    
        for(int i=2;i<n;i++)
        {
            int max=rob[0];
            
            for(int j=1;j<=i-2;j++)
            {
                if(max<rob[j])
                    max=rob[j];
            }
            
            rob[i]=max+nums[i];
            
            if(result<rob[i])
                result=rob[i];
        }
        
        return result;
    }
}