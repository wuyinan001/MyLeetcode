class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n=arr.length;
        
        int k=(int)(n/4.0);
        
        //System.out.println(k);
        
        int curr=arr[0];
        int count=1;
        
        if(count>k)
            return arr[0];
        
        for(int i=1;i<n;i++)
        {
            if(count>k)
                return curr;
            
            if(arr[i]==curr)
                count++;
            else
            {
                count=1;
                curr=arr[i];
            }
        }
        
        if(count>k)
                return curr;
        
        return -1;
    }
}