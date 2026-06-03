// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Initially robot faces north and starts moving as per the input instructions.If its back to the origin after one
cycle or not facing north, then its in a loop. This means it will stay bounded in a circle/cycle.
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int idx = 0;
        int[][] dirs = new int[][] {{-1, 0} , {0, -1}, {1, 0}, {0, 1}};
        int x = 0 , y = 0;

        for(char ch : instructions.toCharArray()) {
            if(ch == 'G') {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
            else if(ch == 'L') {
                idx = (idx + 1) % 4;
            }
            else if(ch == 'R') {
                idx = (idx + 3) % 4;
            }
        }

        if(idx != 0 || (x == 0 && y == 0))
            return true;
        return false;
    }
}