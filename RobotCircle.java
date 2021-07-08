// Time Complexity : O(n) where n is the number of instructions
// Space Complexity : O(1) in place 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with direction formulas
/* Your code here along with comments explaining your approach: Observe the directions, if the person is facing north after moving for all the instructions
it will be always false, unless it is coming back at origin. Hence, the direction will change as per the instruction and the x and y coordinates wil
move according to the dirs array as G instructions comes up.
*/
class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) return true;
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};                                              // Moving in all four directions
        int dir = 0;
        int x = 0, y = 0;
        for(int i= 0; i < instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'L') {
                dir = (dir + 1) % (dirs.length);                                                                // If left turn, move to the correct direction
            } else
            if(c == 'R'){
                dir = (dir + 3) % (dirs.length);                                                        // If right turn, find the correct direction to go
            } else
            {
                x += dirs[dir][0];                                                                      // If G, increment your steps to respective coordinates
                y += dirs[dir][1];
            }   
        }
        return dir != 0 || (x == 0 && y == 0);                                                  // If at the end, direction is not north or it is at origin
    }
}