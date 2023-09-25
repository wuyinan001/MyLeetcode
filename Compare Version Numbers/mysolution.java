class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] strs1=version1.split("\\.");
        String[] strs2=version2.split("\\.");
        
        for(int i=0;i<Math.min(strs1.length,strs2.length);i++)
        {
            int n1=Integer.parseInt(strs1[i]);
            int n2=Integer.parseInt(strs2[i]);
            
            
            if(n1<n2)
                return -1;
            else if(n1>n2)
                return 1;
        }
        
        int l1=strs1.length, l2=strs2.length;
        
        if(l1==l2)
            return 0;
        
        if(l1<l2)
        {
            for(int i=l1;i<l2;i++)
                if(Integer.parseInt(strs2[i])!=0)
                    return -1;
            
            return 0;
        }
        
        for(int i=l2;i<l1;i++)
            if(Integer.parseInt(strs1[i])!=0)
                return 1;

        return 0;
    }
}