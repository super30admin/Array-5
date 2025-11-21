// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Using direction array ie North, West, South and East we check for the rotation in anticlockwise direction
//After one set of instructions, if it's back at origin or not facing North, it’s in a loop.

class Solution {
    public boolean isRobotBounded(String instructions) {
                                        //N.    //W         //S.      //E
        int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int idx = 0; //index on dirs
        int x = 0;
        int y = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                x += dirs[idx][0];
                y += dirs[idx][1];
            } else if (ch == 'L') {
                idx = (idx + 1) % 4;
            } else {
                //R
                idx = (idx + 3) % 4;
            }
        }
        if ((x == 0 && y == 0) || idx != 0)
            return true;
        return false;
    }
}
