// Time Complexity : O(n) where n is the length of the string instructions
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// logic: after 1 iter if robit reaches back to origin or robit is not facing north, then it can be encircled

class robotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int i = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int j = 0; j < instructions.length(); j++) {
            char c = instructions.charAt(j);
            if (c == 'L') {
                i = (i + 3) % 4;
            }
            else if (c == 'R') {
                i = (i + 1) % 4;
            }
            else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return (x == 0 && y == 0) || i != 0;
    }
}