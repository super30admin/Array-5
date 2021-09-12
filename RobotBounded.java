// Time Complexity : O(n) n - length of the string
// Space Complexity : O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0)
            return true;
        //              N       E       S       W
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0; //North direction
        int x = 0; int y = 0; //origin
        for(int j = 0; j < instructions.length(); j++) {
            char c = instructions.charAt(j);
            if(c == 'L') {
                i = (i + 3) % 4;
            }
            else if(c == 'R') {
                i = (i + 1) % 4;
            }
            else {
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return ((x == 0 && y == 0) || i != 0);
    }
}