/* Time Complexity : O(n) 
 * n = length of instructions string */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isRobotBounded(String instructions) {   
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};   //NWSE - anti-clockwise
        int idx = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < instructions.length(); j++){
                char c = instructions.charAt(j);
                if(c == 'G'){
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                } else if(c == 'L'){
                    idx = (idx + 1) % 4;
                } else {
                    idx = (idx + 3) % 4;
                }
            }
        }
        return ((x == 0 && y == 0) || idx != 0);
    }
}