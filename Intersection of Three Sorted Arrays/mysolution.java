class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        List<Integer> ans=new ArrayList();
        
        int n1=arr1.length, n2=arr2.length, n3=arr3.length;
        int i=0,j=0,k=0;
        
        while(i<n1&&j<n2&&k<n3)
        {
            if(arr1[i]==arr2[j]&&arr2[j]==arr3[k])
            {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else
            {
                int max=Math.max(Math.max(arr1[i],arr2[j]),arr3[k]);
                
                while(arr1[i]<max)
                {
                    i++;
                    if(i==n1)
                        return ans;
                }
                
                while(arr2[j]<max)
                {
                    j++;
                    if(j==n2)
                        return ans;
                }
                
                while(arr3[k]<max)
                {
                    k++;
                    if(k==n3)
                        return ans;
                }
            }
                
        }
        
        return ans;
    }
}