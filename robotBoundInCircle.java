// Time Complexity = O(n) where n=len of instructions
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Here we create a dirs array in either clockwise or anticlockwise direction.
// The default direction where we look at the start is to the North, so after 1 traversal of the instructions string, if we are pointing to any direction other than North or we are at the starting spot, we are in a loop.

class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return true;

        int x=0, y=0;   // x & y are the dimentions of the person, at the beginning the person is standing at 0,0
        int j=0;    // j is the direction I am looking at. Initially at N.

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};    //clockwise direction representing N, E, S, W

        for (int i=0; i<instructions.length(); i++) {
            char c = instructions.charAt(i);

            if (c == 'L') {
                j = (j+3) % 4;    // If I am looking at North and get a L, I now look at West, which is at index +3 in dirs array from North
            }
            else if (c == 'R') {
                j = (j+1) % 4;    // If I am looking at North and get a L, I now look at West, which is at index +1 in dirs array from North
            }
            else {                // we have a 'G'
                x += dirs[j][0];
                x += dirs[j][1];
            }
        }

        // We return true if at the end of 1 iteration of instructions, we are at the starting spot
        // or are not looking at North
        return (x == 0 && y == 0) || (j != 0);
    }
}