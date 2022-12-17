// Time Complexity: O(n), n is length of string
// Space Complexity: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) return true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//NESW

        int i =0;
        int x=0, y=0;

        for (int j =0; j < instructions.length(); j++) {
            char c = instructions.charAt(j);

            if (c == 'G') {
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            } else if (c == 'R') {
                i = (i + 1) % 4;
            } else if (c == 'L') {
                i = (i + 3) % 4;
            }
        }

        return (x == 0 && y == 0) || (i !=0);

    }
}