import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) where n = length of instruction
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1041. Robot Bounded In Circle (Medium) - https://leetcode.com/problems/robot-bounded-in-circle/
// Time Complexity : O(n) where n = length of instruction
// Space Complexity : O(1)
//class Solution {
//	public boolean isRobotBounded(String instructions) {
//		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N E S W
//		int x = 0, y = 0;
//		int i = 0; // this denotes the direction in which the robot is moving (0 - N, 1 - E, 2 - S,
//					// 3 - W)
//
//		for (int j = 0; j < 4; j++) {
//			for (int k = 0; k < instructions.length(); k++) {
//				char ch = instructions.charAt(k);
//
//				if (ch == 'G') {
//					x += dirs[i][0];
//					y += dirs[i][1];
//				} else if (ch == 'L') {
//					i = (i + 3) % 4;
//				} else if (ch == 'R') {
//					i = (i + 1) % 4;
//				}
//			}
//
//			if (x == 0 && y == 0)
//				return true;
//		}
//
//		return (x == 0 && y == 0);
//	}
//}

class Solution {
	public boolean isRobotBounded(String instructions) {
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N E S W
		int x = 0, y = 0;
		int i = 0; // this denotes the direction in which the robot is moving

		for (int k = 0; k < instructions.length(); k++) {
			char ch = instructions.charAt(k);

			if (ch == 'G') {
				x += dirs[i][0];
				y += dirs[i][1];
			} else if (ch == 'L') {
				i = (i + 3) % 4;
			} else if (ch == 'R') {
				i = (i + 1) % 4;
			}
		}

		return (x == 0 && y == 0) || (i != 0);
	}
}