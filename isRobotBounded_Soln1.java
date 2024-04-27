package week14.day2;
//TC - O(4L)
//SC - O(1)
class Solution {
  public boolean isRobotBounded(String instructions) {
      int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N, E, S, W
      int startDir = 0;
      int x = 0;
      int y = 0;

      for (int step = 0; step < 4; step++) {
          for (int i = 0; i < instructions.length(); i++) {
              char ch = instructions.charAt(i);
              if (ch == 'G') {
                  x = x + directions[startDir][0];
                  y = y + directions[startDir][1];
              } else if (ch == 'L') {
                  startDir = (startDir + 3) % 4;
              } else if (ch == 'R') {
                  startDir = (startDir + 1) % 4;
              }
          }
      }
      if (x == 0 && y==0)
          return true;

      return false;
  }
}
/** 
1. Create dirs in clockwise
2. Start dir is North - 0 as per dirs array
3. As per set of instructions, move robot.
4. Execute instructions at most 4 times and if robot lands at 0,0 return true
*/
public class isRobotBounded_Soln1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
