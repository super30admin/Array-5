// Approach: One pass: as a limit cycle trajectory returns to the initial point {0,0} after at most 4 cycles.
// We do not need 4 cycles to identify the limit cycle trajectory. One cycle is enough.
// Two key points -
// 1. If the robot returns to the initial point after one cycle, that's the limit cycle trajectory.
// 2. If the robot doesn't face north at the end of the first cycle, that's the limit cycle trajectory.
// Time: O(n)
// Space: O(1)

class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
                                //    N      E      S       W
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int n = instructions.length();
        int x = 0, y = 0;
        int i = 0;      // index on dirs[] array.
        for (int j = 0; j<n; j++) {
            char c = instructions.charAt(j);
            if (c == 'R') {
                i = (i+3) % 4;
            } else if (c == 'L') {
                i = (i+1) % 4;
            } else {
                // Go
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return (x == 0 && y == 0) || i != 0;
    }
}