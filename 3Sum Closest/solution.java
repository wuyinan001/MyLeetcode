class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int n=nums.length;
        
        for(int k=0;;k++)
        {
            for(int i=0;i<=n-3;i++)
            {
                for(int j=i+1;j<=n-2;j++)
                {
                    if(binarySearch(nums,j+1,n-1,target+k-nums[i]-nums[j])!=-1)
                    {
                        //System.out.println(binarySearch(nums,j+1,n-1,target+k-nums[i]-nums[j]));
                        //System.out.println("i:"+i+" j:"+j);
                        return target+k;
                    }
                    
                    if(binarySearch(nums,j+1,n-1,target-k-nums[i]-nums[j])!=-1)
                    {
                        //System.out.println(binarySearch(nums,j+1,n-1,target-k-nums[i]-nums[j]));
                        //System.out.println("i:"+i+" j:"+j);
                        return target-k;
                    }    
                }
            }
        }
        
    }
    
    private int binarySearch(int[] nums, int lo, int hi, int key)
    {
        int mid=lo+(hi-lo)/2;
        
        while(lo<=hi)
        {
            if(nums[mid]==key)
                return mid;
            
            if(nums[mid]<key)
                lo=mid+1;
            else
                hi=mid-1;
            
            mid=lo+(hi-lo)/2;
        }
        
        return -1;
    }
}