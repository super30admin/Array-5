// Time Complexity : O(n); n - length of instructions
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RobotBoundedByCircle {

    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}}; // NESW
        int i = 0; // keep track of direction robot is pointing
        int r = 0, c = 0;
        for(int j = 0; j < instructions.length(); j++){
            char ch = instructions.charAt(j);

            if(ch == 'L'){
                i = (i+3)%4;
            }else if(ch == 'R'){
                i = (i+1)%4;
            }else {//G
                r+= dirs[i][0];
                c+= dirs[i][1];
            }
        }
        //For robot to be bounded in circle,
        //after first set of instructions, robot has to be back to origin or should not be facing north
        return (r == 0 && c == 0) || i != 0;
    }
}
