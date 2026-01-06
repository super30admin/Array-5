// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
idea here is that if the robot that to come back to orgin its will happen in 4 instruction cycle
if not robot will never come back that would be (O(4n))
but to reduce the logic even more we cycle though the instructions one time and if the robot is not facing north if will surely come back
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int idx = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'L') {
                idx = (idx + 1) % 4;
            } else if (ch == 'R') {
                idx = (idx + 3) % 4;
            } else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        if ((x == 0 && y == 0) || idx != 0)
            return true;
        return false;
    }
}