// Time Complexity: O(n) – single pass over the instruction string.
// Space Complexity: O(1) – constant extra space for position and direction.

// Simulate the robot: track (x, y) and a direction index over {N, W, S, E}; move on 'G', rotate idx on 'L'/'R'.
// After one pass, if the robot returns to origin (x == 0 && y == 0), it’s bounded.
// Otherwise, it’s still bounded if it’s not facing the original direction (idx != 0), since repeating will loop back.

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, { 0,-1}, {1, 0}};

        int x = 0, y = 0;
        int idx = 0;

        for(char c: instructions.toCharArray()){
            if(c == 'G'){
                x += dirs[idx][0];
                y += dirs[idx][1];
            }else if(c == 'L'){
                idx = (idx + 1 ) % 4;
            }else if( c == 'R'){
                idx = (idx + 3) % 4;
            }
        }

        if((x == 0 && y == 0) || idx != 0) return true;
    
        return false;
    }
}
