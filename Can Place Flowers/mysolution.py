class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        m=len(flowerbed)
        curr_pos=0
        
        for j in range(n):
            placed=False
            while curr_pos<m:
                if flowerbed[curr_pos]==0:
                    if curr_pos>0 and curr_pos<m-1 and flowerbed[curr_pos-1]==0 and flowerbed[curr_pos+1]==0:
                        flowerbed[curr_pos]=1
                        placed=True
                        break
                    elif curr_pos>0 and curr_pos==m-1 and flowerbed[curr_pos-1]==0:
                        flowerbed[curr_pos]=1
                        placed=True
                        break
                    elif curr_pos==0 and curr_pos<m-1 and flowerbed[curr_pos+1]==0:
                        flowerbed[curr_pos]=1
                        placed=True
                        break
                    elif curr_pos==0 and curr_pos==m-1:
                        placed=True
                        break
                curr_pos+=1
                
            if not placed:
                return False
        
        return True