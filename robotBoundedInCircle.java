/*
Problem: https://leetcode.com/problems/robot-bounded-in-circle/

Intuition: After one round of instructions, if the robot is facing North, it will never come back to the origin.
So it will not be bounded. Robot will be bounded if it ends up in any other direction after the first set of instructions.
*/
class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0)
            return true;
        
        int dirs[][] = new int[4][2];
        dirs[0] = new int[]{0, 1};      // North
        dirs[1] = new int[]{1, 0};      // East
        dirs[2] = new int[]{0, -1};     // South
        dirs[3] = new int[]{-1, 0};     // West
        
        int curDirection = 0;
        int xCoordinate = 0;
        int yCoordinate = 0;
        
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                xCoordinate += dirs[curDirection][0];
                yCoordinate += dirs[curDirection][1];
            } else if (instruction == 'L') {
                curDirection = moveLeft(dirs, curDirection);
            } else if (instruction == 'R') {
                curDirection = moveRight(dirs, curDirection);
            }
        }
        
        // Return true if current direction is not north or if it is north but the robot is at origin
        return ((curDirection != 0) || (xCoordinate == 0 && yCoordinate == 0));
    }
    
    // Returns new direction (i.e index in the dirs array) after moving right from the direction
    private int moveRight(int dirs[][], int curDirection) {
        int newDirection = (curDirection + 1) % 4;
        return newDirection;
    }
    
    // Returns new direction (i.e index in the dirs array) after moving left from the direction
    private int moveLeft(int dirs[][], int curDirection) {
        int newDirection = (curDirection + 3) % 4;
        return newDirection;
    }
}