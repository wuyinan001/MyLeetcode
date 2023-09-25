class SnapshotArray:

    def __init__(self, length: int):
        self.array=[{} for i in range(length)]
        self.id=0
        
        for dict1 in self.array:
            dict1[self.id]=0

    def set(self, index: int, val: int) -> None:
        self.array[index][self.id]=val

    def snap(self) -> int:
        ans=self.id
        self.id+=1
        return ans

    def get(self, index: int, snap_id: int) -> int:
        dict1=self.array[index]
        while snap_id not in dict1.keys():
            snap_id-=1
        
        return dict1[snap_id]


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)