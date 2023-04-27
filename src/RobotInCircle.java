//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take directions matrix for 4 directions. If G, then add current index of
 * direction. If R, then idx+1, else if L, then idx+3 index direction would
 * work. After one iteration of entire string, check if x and y are 0 or idx is
 * not 0.
 *
 */
class Solution {
	public boolean isRobotBounded(String instructions) {
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0, y = 0;
		int idx = 0;
		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				x += dirs[idx][0];
				y += dirs[idx][1];
			} else if (c == 'R')
				idx = (idx + 1) % 4;
			else
				idx = (idx + 3) % 4;
		}
		return (x == 0 && y == 0) || idx != 0;
	}
}
