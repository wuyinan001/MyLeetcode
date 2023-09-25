class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int n=nums.length;
        
        int[] odd=new int[n/2];
        int[] even=new int[n/2];
        
        int k1=0, k2=0;
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2!=0)
                odd[k1++]=nums[i];
            else
                even[k2++]=nums[i];
        }
        
        //Arrays.sort(odd);
        //Arrays.sort(even);
        
        k1=0;
        k2=0;
        
        for(int i=0;i<n;i++)
        {
            if(i%2!=0)
                nums[i]=odd[k1++];
            else
                nums[i]=even[k2++];
        }
        
        return nums;
    }
}