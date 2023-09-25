class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum=0,n=arr.length;
        
        for(int i:arr)
            sum+=i;
        
        //System.out.println("sum "+sum);
        
        if(sum%3!=0||n<3)
            return false;
        
        Map<Integer,Integer> map=new HashMap();
        
        int curr=0;
        
        if(sum==0)
        {
            for(int i=0;i<n;i++)
            {
                curr+=arr[i];

                if(curr==0)
                    map.put(curr,map.getOrDefault(curr,0)+1);

                if(map.containsKey(0)&&map.get(0)>2)
                    return true;
            }
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                curr+=arr[i];

                if(curr==sum/3||curr==sum/3*2)
                    map.put(curr,i);

                if(map.containsKey(sum/3)&&map.containsKey(sum/3*2)&&map.get(sum/3)<map.get(sum/3*2))
                    return true;
            }
        }
        
        return false;
    }
}