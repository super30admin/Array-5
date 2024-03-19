public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        return isRobotBoundedWithoutRepeat(instructions);
    }

    // TC: O(N) where N is length of instructions
    // SC: O(1)
    private boolean isRobotBoundedWithoutRepeat(String instructions) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N,E,S,W
        int directionIndex = 0;
        int x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char currChar = instructions.charAt(i);
            if (currChar != 'G') {
                if (currChar == 'L') {
                    directionIndex = (directionIndex + 3) % 4;
                } else {
                    directionIndex = (directionIndex + 1) % 4;
                }
            } else {
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];
            }
        }
        return (x == 0 && y == 0) || directionIndex != 0;
    }

    // TC: O(4N) where N is length of instructions
    // SC: O(1)
    private boolean isRobotBoundedRepeat4Times(String instructions) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N,E,S,W
        int directionIndex = 0;
        int x = 0, y = 0;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < instructions.length(); i++) {
                char currChar = instructions.charAt(i);
                if (currChar != 'G') {
                    if (currChar == 'L') {
                        directionIndex = (directionIndex + 3) % 4;
                    } else {
                        directionIndex = (directionIndex + 1) % 4;
                    }
                } else {
                    x += directions[directionIndex][0];
                    y += directions[directionIndex][1];
                }
            }
        }
        return x == 0 && y == 0;
    }
}
