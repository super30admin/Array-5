// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // N E S W
        int x = 0;
        int y = 0;
        int i = 0;
        for (int ind = 0; ind < instructions.length(); ind++) {
            char c = instructions.charAt(ind);
            // if robot goes left
            if (c == 'L') {
                i = (i + 3) % 4;
            }
            // if robot goes right
            else if (c == 'R') {
                i = (i + 1) % 4;
            } else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        // if robot does not face same direction again or is back at origin return true
        return (x == 0 && y == 0) || i != 0;
    }
}