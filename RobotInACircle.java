/*
Time complexity: O(N)
Space Complexity: O(1)
Any difficulties: no
Run on leetcode: Yes

Approach:
**Well Commented code**
 */
public class RobotInACircle {
    public static int[][] directions = {
            {0,1}, // North
            {1,0}, // East
            {0,-1}, // South
            {-1,0} // West
    };
    public static boolean isRobotBound(String instructions){

            int x = 0;
            int y = 0;
            int dir = 0; // Robot Facing North

            for(char c: instructions.toCharArray()){
                if(c == 'G'){ // Move Forward
                    x+=directions[dir][0];
                    y+=directions[dir][1];
                }else if(c == 'L'){ // If the left command is there then move to the left direction
                    dir = (dir+3)%4;
                }else{ // If right command is there then move in the right direction
                    dir = (dir+1)%4;
                }
            }

            // x = y == 0 means that Robot has reached origin and it's face can be in any direction
            return (x == 0 && y == 0) || dir!= 0;
    }
    public static void main(String[] args){
        System.out.println("Is Robot Bound in Circle: "+ isRobotBound("GGLLGG"));
        System.out.println("Is Robot Bound in Circle: "+ isRobotBound("GG"));
        System.out.println("Is Robot Bound in Circle: "+ isRobotBound("GL"));
    }
}
