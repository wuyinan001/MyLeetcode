def maximumSwap(self, num: int) -> int:
        list1=[]
        while num>0:
            list1.append(num%10)
            num=int(num/10)
        
        list1.reverse()

        n=len(list1)
        swap=False
        maxGap=0
        idx=-1
        jdx=-1

        for i in range(n-1):
            if list1[i]==9:
                continue
            for j in range(i+1,n):
                if list1[i]<list1[j]:
                    swap=True
                    if maxGap<=list1[j]-list1[i]:
                        maxGap=list1[j]-list1[i]
                        idx=i
                        jdx=j
            if swap:
                t=list1[idx]
                list1[idx]=list1[jdx]
                list1[jdx]=t
                break

        ans=0

        for i in list1:
            ans=ans*10+i

        return ans        
