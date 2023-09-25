class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        read=0
        write=0
        while read<n:
            if nums[write]==nums[read]:
                read+=1
            else:
                write+=1
                nums[write]=nums[read]
                read+=1
        
        return write+1