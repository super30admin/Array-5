public class RobotBounded {
	public boolean isRobotBounded(String instructions) {

		if (instructions.length() == 0 || instructions == null)
			return false;

		int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

		int n = 0; // north
		int x = 0;
		int y = 0; // initial robot co-ordinates
		for (int i = 0; i < instructions.length(); i++) {

			if ('L' == instructions.charAt(i)) {
				n = (n + 1) % 4;

			} else if ('R' == instructions.charAt(i)) {
				n = (n + 3) % 4;

			} else {
				x += dirs[n][0];
				y += dirs[n][1];
			}

		}
		if (n != 0 || (x == 0 && y == 0))
			return true;

		return false;

	}
}
