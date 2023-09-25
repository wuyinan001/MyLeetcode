/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        return firstBadVersion(1,n);
        
    }
    
    private int firstBadVersion(int lo, int hi)
    {
        if(lo==hi)
            return lo;
        
        int mid=lo+(hi-lo)/2;
        
        if(isBadVersion(mid))
            return firstBadVersion(lo,mid);
        else
            return firstBadVersion(mid+1,hi);
    }
}