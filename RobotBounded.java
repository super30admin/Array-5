// Time Complexity: O(n) where n = length of instructions
// Space Complexity: O(1)

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

    public boolean isRobotBounded(String instructions) {      
        int dir = 0;
        int x = 0;
        int y = 0;
        // loop over instructions
        for(int i=0; i<instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'R') { // right
                dir = (dir + 1) % 4; // to get direction when turned right
            } else if (c == 'L') { // left
                dir = (dir + 3) % 4; // to get direction when turned left
            } else { // G - move 1 step forward in the same direction
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
        }
        // return true if xand y equals 0 or the final direction is not up
        return x == 0 && y == 0 || dir > 0;
    }
}