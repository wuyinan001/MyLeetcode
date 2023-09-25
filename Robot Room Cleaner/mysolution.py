# """
# This is the robot's control interface.
# You should not implement it, or speculate about its implementation
# """
#class Robot:
#    def move(self):
#        """
#        Returns true if the cell in front is open and robot moves into the cell.
#        Returns false if the cell in front is blocked and robot stays in the current cell.
#        :rtype bool
#        """
#
#    def turnLeft(self):
#        """
#        Robot will stay in the same cell after calling turnLeft/turnRight.
#        Each turn will be 90 degrees.
#        :rtype void
#        """
#
#    def turnRight(self):
#        """
#        Robot will stay in the same cell after calling turnLeft/turnRight.
#        Each turn will be 90 degrees.
#        :rtype void
#        """
#
#    def clean(self):
#        """
#        Clean the current cell.
#        :rtype void
#        """

class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.visited = set([])
        self.robot: Robot = None
    
    def goBack(self):
        self.robot.turnLeft()
        self.robot.turnLeft()
        self.robot.move()
        self.robot.turnLeft()
        self.robot.turnLeft()
        
    def dfs(self,row,col,direction):
        self.robot.clean()
        self.visited.add((row,col))
        
        for dir1 in range(4):
            d=(direction+dir1)%4
            x=row+self.dirs[d][0]
            y=col+self.dirs[d][1]
            
            if (x,y) not in self.visited and self.robot.move():
                self.dfs(x,y,d)
            
            self.robot.turnLeft()
        
        self.goBack()
    
    def cleanRoom(self, robot):
        """
        :type robot: Robot
        :rtype: None
        """
        self.robot=robot
        self.dfs(0,0,0)