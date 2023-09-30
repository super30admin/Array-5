// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RobotBoundedInCircle {
    // 4 pass solution
    public boolean isRobotBounded(String instructions) {
        //   N     E     S      W
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};   // clockwise direction
        int x = 0; int y = 0;
        int idx = 0;
        for(int times = 0; times<4; times++)
        {
            for(int i=0; i<instructions.length(); i++){

                char c = instructions.charAt(i);

                if(c == 'G'){
                    x+= dirs[idx][0];
                    y+= dirs[idx][1];
                }else if(c == 'L'){
                    idx = (idx+3) % 4;
                }else if(c == 'R'){
                    idx = (idx+1) % 4;
                }
            }

            if(x==0 && y==0) return true;
        }
        return false;
    }
}
