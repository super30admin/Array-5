class Solution {
    public boolean isRobotBounded(String instructions) {
        // Tc: O(n) Sc: O(1)
        int x = 0;
        int y = 0;
        // NESW
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int dir = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char instr = instructions.charAt(i);
            if (instr == 'G') {
                x += directions[dir][0];
                y += directions[dir][1];
            }

            else if (instr == 'L') {
                dir = (dir + 3) % 4;
            }

            else if (instr == 'R') {
                dir = (dir + 1) % 4;
            }
        }

        return x == 0 && y == 0 || dir != 0;
    }

}