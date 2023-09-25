class Solution:
    def dp(self,nums,index,left,right,sumA,sumB,memo):
        if index==len(nums):
            return abs(sumA-sumB)
        
        if str(index)+"%"+left+"%"+right in memo:
            return memo[str(index)+"%"+left+"%"+right]

        ans=float('inf')

        list1=left.split("%")
        list2=right.split("%")

        if len(list1)-1==int(len(nums)/2):
            ans=self.dp(nums,index+1,left,right+"%"+str(index),sumA,sumB+nums[index],memo)
        elif len(list2)-1==int(len(nums)/2):
            ans=self.dp(nums,index+1,left+"%"+str(index),right,sumA+nums[index],sumB,memo)
        else:
            ans=min(self.dp(nums,index+1,left,right+"%"+str(index),sumA,sumB+nums[index],memo),\
            self.dp(nums,index+1,left+"%"+str(index),right,sumA+nums[index],sumB,memo))

        memo[str(index)+"%"+left+"%"+right]=ans
        return ans

    def minimumDifference(self, nums: List[int]) -> int:
        sum1=sum(nums)
        
        memo={}

        return self.dp(nums,0,"","",0,0,memo)