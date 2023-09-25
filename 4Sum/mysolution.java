class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        int n=nums.length;
        
        if(n==0)
            return ans;
        
        HashSet<List<Integer>> set=new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                List<List<Integer>> list=twoSum(nums,j+1,n-1,target-nums[i]-nums[j]);
                
                //System.out.println(list);
                
                if(!list.isEmpty())
                {
                    for(List<Integer> l:list)
                    {
                        List<Integer> temp=new ArrayList<>();
                    
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.addAll(l);
                        set.add(temp);
                    }
                }
            }
        }
        
        for(List<Integer> i:set)
        {
            ans.add(i);
        }
        
        return ans;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int lo, int hi, int key)
    {
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=lo;i<=hi;i++)
        {
            int j=binary(nums,i+1,hi,key-nums[i]);
            if(j!=-1)  
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
            }
                
        }
        
        return ans;
    }
    
    private int binary(int[] nums, int lo, int hi, int key)
    {
        int mid=lo+(hi-lo)/2;
        
        while(lo<=hi)
        {
            if(nums[mid]==key)
                return mid;
            
            if(nums[mid]<key)
            {
                lo=mid+1;
            }
            else
                hi=mid-1;
            
            mid=lo+(hi-lo)/2;
        }
        
        return -1;
    }
}