/**
 * Simulates robot movement based on instructions with directions and turns.
 * Determines if the robot stays in a bounded circle after repeating instructions.
 * Returns true if bounded (either returns to origin or not facing north).
 */
// Time Complexity: O(N), where N is the number of instructions
// Space Complexity: O(1), since only constant variables are used
public class RobotBoundedInACircle {

    public boolean isRobotBounded(String instructions) {

        int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};

        int x = 0; 
        int y = 0; 
        int idx = 0;

        for(int i = 0; i <= 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                } else if(c == 'L') {
                    idx = (idx+1) %4;
                } else if (c == 'R') {
                    idx = (idx+3) %4;
                }
            }
        }
        if((x == 0 && y == 0) || idx != 0 ) return true;
        return false;
    }
    
}
