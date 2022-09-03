// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class RobotBoundedInCircle {
    class Solution {
        public boolean isRobotBounded(String instructions) { //GGLLGG
            int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}}; //  N W S E - antclockwise
            int dir = 0; //ititially facing north
            //coordinates
            int x=0;
            int y=0;
            for(int i = 0; i < instructions.length(); i++) { //3
                char ch = instructions.charAt(i); // L
                if(ch == 'L'){
                    dir = (dir+1) % 4; // 1
                } else if (ch == 'R') {
                    dir = (dir+3) % 4;
                } else {
                    x += dirs[dir][0]; // 0
                    y += dirs[dir][1]; // 2
                }
            }

            return (x==0 && y==0) || dir != 0;
        }
    }
}
