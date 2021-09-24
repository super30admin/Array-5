// Time Complexity : O(n), n -> Length of instructions
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class RobotBoundedInCircle {
	public boolean isRobotBounded(String instructions) {
		if (instructions == null || instructions.length() == 0) {
			return true;
		}

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int x = 0;
		int y = 0;

		int dir = 0;

		for (int i = 0; i < instructions.length(); i++) {
			char ch = instructions.charAt(i);
			if (ch == 'L') {
				dir = (dir + 3) % 4;
			} else if (ch == 'R') {
				dir = (dir + 1) % 4;
			} else {
				x += dirs[dir][0];
				y += dirs[dir][1];
			}
		}

		return (x == 0 && y == 0) || dir != 0;
	}

	public static void main(String[] args) {
		RobotBoundedInCircle obj = new RobotBoundedInCircle();

		String instructions = "GGLLGG";

		System.out.println("Is the robot bounded in a circle? " + (obj.isRobotBounded(instructions) ? "Yes" : "No"));
	}

}
