// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        if(n == 0)
            return true;
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // North, West, South, East -> anticlockwise
        int x = 0;
        int y = 0;
        int idx = 0; // index of dirs array which will keep track of my direction
        for(int j = 0; j < n; j++) {
            char c = instructions.charAt(j);
            if(c == 'L') {
                idx = (idx + 1) % 4;
            } else if(c == 'R') {
                idx = (idx + 3) % 4;
            } else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        return (x == 0 && y == 0) || (idx != 0);
    }
}