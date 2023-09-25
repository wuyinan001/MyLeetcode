class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1=new HashSet<Integer>();
        HashSet<Integer> s2=new HashSet<Integer>();
        
        for(int i=0;i<nums1.length;i++)
        {
            s1.add(nums1[i]);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            s2.add(nums2[i]);
        }
        
        s1.retainAll(s2);
        
        int n=s1.size();
        
        int[] result=new int[n];
        
        //Iterator<Integer> i=s1.iterator();
        
        int index=0;
        
        for(int i:s1)
            result[index++]=i;
        
        return result;
    }
}