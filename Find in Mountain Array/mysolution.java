/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    private int findPeakIndex(MountainArray mountainArr, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        
        if(lo==hi)
            return lo;
        
        int mid=lo+(hi-lo)/2;
        
        if(mid==0)
        {
            if(mountainArr.get(mid)>mountainArr.get(mid+1))
                return mid;
            else
                return findPeakIndex(mountainArr,mid+1,hi);
        }
        
        if(mountainArr.get(mid)>mountainArr.get(mid+1)&&mountainArr.get(mid)>mountainArr.get(mid-1))
            return mid;
        else if(mountainArr.get(mid)<mountainArr.get(mid+1))
            return findPeakIndex(mountainArr,mid+1,hi);
        else
            return findPeakIndex(mountainArr,lo,mid-1);
    }
    
    private int binarySearch1(int target, MountainArray mountainArr, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        
        int mid=lo+(hi-lo)/2;
        
        if(mountainArr.get(mid)==target)
            return mid;
        
        if(target<mountainArr.get(mid))
            return binarySearch1(target,mountainArr, lo, mid-1);
        
        return binarySearch1(target,mountainArr,mid+1, hi);
    }
    
    private int binarySearch2(int target, MountainArray mountainArr, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        
        int mid=lo+(hi-lo)/2;
        
        if(mountainArr.get(mid)==target)
            return mid;
        
        if(target>mountainArr.get(mid))
            return binarySearch2(target,mountainArr, lo, mid-1);
        
        return binarySearch2(target,mountainArr,mid+1, hi);
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int len=mountainArr.length();
        
        int peak_index=findPeakIndex(mountainArr,0,len-1);
        
        //System.out.println("peak"+peak_index);
        
        if(target>mountainArr.get(peak_index))
            return -1;
        
        int index1=binarySearch1(target,mountainArr,0,peak_index);
        
        if(index1!=-1)
            return index1;
        
        int index2=binarySearch2(target,mountainArr,peak_index+1,len-1);
        
        return index2;

    }
}