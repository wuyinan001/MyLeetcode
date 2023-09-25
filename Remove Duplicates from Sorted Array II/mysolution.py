class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        write=1
        read=1
        dup=1
        prev=nums[0]
        
        while read<n:
            if read<n and nums[read]==prev:
                if dup==2:
                    read+=1
                else:
                    nums[write]=nums[read]
                    write+=1
                    read+=1
                    dup+=1
            elif read<n and nums[read]>prev:
                nums[write]=nums[read]
                prev=nums[write]
                read+=1
                write+=1
                dup=1
        
        return write