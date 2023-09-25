from random import randint

class RandomizedSet:

    def __init__(self):
        self.list=[]
        self.dict={}

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        else:
            self.list.append(val)
            self.dict[val]=len(self.list)-1
            return True

    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False
        else:
            index:int =self.dict[val]
            if index!=len(self.list)-1:
                self.dict[self.list[-1]]=index
                self.list[index]=self.list[-1]
            
            self.list.pop()
            self.dict.pop(val)
            return True

    def getRandom(self) -> int:
        return self.list[randint(0,len(self.list)-1)]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()