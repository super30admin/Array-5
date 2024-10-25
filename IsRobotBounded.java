// Problem 1041. Robot Bounded In Circle
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, i = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                i = (i + 1) % 4;
            } else if (c == 'L') {
                i = (i + 3) % 4;
            } else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        if ((x == 0 && y == 0) || (i != 0)) {
            return true;
        }
        return false;
    }
}