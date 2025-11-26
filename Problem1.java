/*
1041. Robot Bounded In Circle
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Loop through instructions, and move in appropriate direction if at the end of first iteration if it is not facing north then we can say robot is in bouded circle, because if we face anyother direction we will eventually converge to origin.
*/
class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // N. W, S, E - anti clockwise

        // Starts from origin
        int x = 0;
        int y = 0;
        int idx = 0;

        for(char instruction: instructions.toCharArray()){
            if(instruction == 'G'){ // Move ahead in the direction where it is facing
                x += dirs[idx][0]; 
                y += dirs[idx][1];
            } else if(instruction == 'L'){ // Turn 90 degree left
                idx = (idx + 1) % 4;
            } else if(instruction == 'R'){ // Turn 90 degree right
                idx = (idx + 3) % 4;
            }
        }

        if((x == 0 && y == 0) || idx != 0){ // If it is at origin or not facing north
            return true;
        }

        return false;
    }
}