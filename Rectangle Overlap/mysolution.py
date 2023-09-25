class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        x_overlap=False
        y_overlap=False
        
        if rec1[0]<=rec2[0]:
            x_overlap=True if rec1[2]>rec2[0] else False
        else:
            x_overlap=True if rec2[2]>rec1[0] else False
        
        if rec1[1]<=rec2[1]:
            y_overlap=True if rec1[3]>rec2[1] else False
        else:
            y_overlap=True if rec2[3]>rec1[1] else False
        
        return x_overlap and y_overlap