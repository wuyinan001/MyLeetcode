class Solution:
    def toArray(self,num):
        ans=[]
        while num>0:
            ans.append(num%10)
            num=int(num/10)
        
        ans.reverse()
        return ans
    
    def swap(self,array,i,j):
        t=array[i]
        array[i]=array[j]
        array[j]=t
        
    def toNum(self,array):
        num=0
        for i in array:
            num=num*10+i
        
        return num
        
    def maximumSwap(self, num: int) -> int:
        list_origin=self.toArray(num)
        list_des=list_origin[:]
        list_des.sort(reverse=True)
        
        n=len(list_origin)
        
        # print(list_origin)
        # print(list_des)
        
        index1=-1
        index2=-1
        
        for i in range(n):
            if list_origin[i]!=list_des[i]:
                index1=i
                break
        
        if index1==-1:
            return num
        
        max_num=max(list_origin[index1+1:])
        
        for i in range(n-1,-1,-1):
            if list_origin[i]==max_num:
                index2=i
                break
        
        # print("index1",index1,"index2",index2)
        # print("org list:",list_origin)
        
        self.swap(list_origin,index1,index2)
        
        # print("ans list:",list_origin)
        
        return self.toNum(list_origin)