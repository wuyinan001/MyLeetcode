class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int key=-(nums[i]+nums[j]);
                int k=binarySearch(nums,key,j+1,n-1);
                
                if(k!=-1)
                {
                    List<Integer> l=Arrays.asList(nums[i],nums[j],nums[k]);
                    
                    if(!set.contains(l))
                    {
                        result.add(l);
                        set.add(l);
                    }         
                } 
            }
        }
        
        return result;
    }
    
    public static int binarySearch(int[] nums, int key, int lo, int hi)
    {
        
        int mid;
        
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            
            if(nums[mid]==key)
                return mid;
            if(nums[mid]<key)
            {
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        
        return -1;
    }
}