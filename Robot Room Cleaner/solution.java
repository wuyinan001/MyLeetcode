/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    Robot robot;
    int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
    Set<Pair<Integer,Integer>> set=new HashSet();
    
    private void goBack()
    {
        robot.turnRight();
        robot.turnRight();
        
        robot.move();
        
        robot.turnRight();
        robot.turnRight();
    }
    
    private void backTrack(int row, int col, int d)
    {
        set.add(new Pair(row,col));
        robot.clean();
        
        for(int i=0;i<4;i++)
        {
            int direction=(d+i)%4;
            int newRow=row+dirs[direction][0],newCol=col+dirs[direction][1];
            
            if(!set.contains(new Pair(newRow,newCol))&&robot.move())
            {
                backTrack(newRow,newCol,direction);
                goBack();
            }
            
            // The robot turns counter clockwise
            robot.turnLeft();
        }
    }
    
    public void cleanRoom(Robot robot) {
        
        this.robot=robot;
        backTrack(0,0,0);
    }
}