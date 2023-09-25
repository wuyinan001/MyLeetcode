class Solution {
    public int firstUniqChar(String s) {
        
        int[] index=new int[128];
        
        for(int i=0;i<s.length();i++)
        {
            index[s.charAt(i)]++;
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(index[s.charAt(i)]==1)
                return i;
        }
        
        return -1;
    }
}