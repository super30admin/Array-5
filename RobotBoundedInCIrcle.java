// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RobotBoundedInCIrcle {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int sLen = instructions.length();

            if(instructions == null || sLen == 0)
                return false;

            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int idx = 0; //for dirs arr

        /*The robot will make circle in 4 repetation : true else false
        //
        if it is facing North after 1st iteration it won't make cycle: false else true*/

            int x = 0, y = 0;

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < sLen; j++){
                    char c = instructions.charAt(j);
                    if(c == 'G'){
                        x += dirs[idx][0];
                        y += dirs[idx][1];
                    }
                    else if(c == 'L'){
                        idx = (idx + 3) % 4;
                    }
                    else{
                        //c = 'R'
                        idx = (idx + 1) % 4;
                    }
                }
            }
            return (x == 0 && y == 0);
        }
    }
}
