class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        Set<Integer> set=new HashSet();
        
        for(int i:arr)
            set.add(i);
        
        for(int i=1;i<=10000;i++)
        {
            if(!set.contains(i))
            {
                k--;
                if(k==0)
                    return i;
            }
        }
        
        return -1;
    }
}