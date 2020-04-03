package com.example.problems;
//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : YES
//Any problem you faced while coding this : NO

//Your
public class RobotBounded {

	public boolean isRobotBounded(String instructions) {
		int size = instructions.length();

		int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x_pos = 0, y_pos = 0,j =0;
		for (int i = 0; i < size; i++) {
			char instruction = instructions.charAt(i);
			if (instruction == 'G') {
				x_pos = x_pos + d[j][0];
				y_pos = y_pos + d[j][1];
			} else if (instruction == 'L') {
				j = (j + 1) % 4;
			} else if (instruction == 'R') {
				j = (j + 3) % 4;
			}
		}
		return x_pos == 0 && y_pos == 0 || j > 0;
	}

	public static void main(String args[]) {
		RobotBounded robot = new RobotBounded();

		String instructions = "GGLLGG";
		System.out.println(robot.isRobotBounded(instructions));

		instructions = "GG";
		System.out.println(robot.isRobotBounded(instructions));

		instructions = "GL";
		System.out.println(robot.isRobotBounded(instructions));

	}

}
