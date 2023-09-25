class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=nums[0];

        
        // L[i] has max product including nums[i]
        int[] L=new int[n];
        
        L[0]=nums[0];
        
        for(int i=1;i<n;i++)
        {   
            L[i]=nums[i];
            
            int P=nums[i];
            
            for(int j=i-1;j>=0;j--)
            {
                P=P*nums[j];
                if(L[i]<P)
                    L[i]=P;
            }
                   
            if(max<L[i])
                max=L[i];
        }
        
        return max;   
    }
}