class Solution {
    
    // Return -1 if s2<s1, 1 if s2>s1, 0 if s1==s2
    private int compareStr(String s1, String s2)
    {
        if(s1.equals(s2))
            return 0;
        
        if(s1.length()>s2.length())
            return -1;
        else if(s1.length()<s2.length())
            return 1;
        else
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    return s2.charAt(i)-s1.charAt(i);
                }
            }
            return -1;
        }
    }
    
    public String kthLargestNumber(String[] nums, int k) {
        
        Arrays.sort(nums,new Comparator<String>(){
            
            public int compare(String n1, String n2)
            {
                return compareStr(n1,n2);
            }
            
        });
        
        return nums[k-1];
    }
}