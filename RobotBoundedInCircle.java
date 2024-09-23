//TC = O(4N)
//SC = O(1)
class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int x = 0;
        int y = 0;
        int[][] dirs = new int[][] {{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
        int idx = 0; // index on directions array

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                char c = instructions.charAt(j);
                if (c == 'G') {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                } else if (c == 'R') {
                    idx = (idx + 1) % 4;
                } else {
                    idx = (idx + 3) % 4;
                }
            }
            if(x == 0 && y == 0)
                return true;
        }
        return false;
    }
}

//2
//TC = O(N)
//SC = O(1)
class RobotBoundedInCircle {
    // Without checking instructions set 4 times
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int x = 0;
        int y = 0;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int idx = 0; // index on directions array

        for (int j = 0; j < n; j++) {
            char c = instructions.charAt(j);
            if (c == 'G') {
                x += dirs[idx][0];
                y += dirs[idx][1];
            } else if (c == 'R') {
                idx = (idx + 1) % 4;
            } else {
                idx = (idx + 3) % 4;
            }
        }
        if ((x == 0 && y == 0) || idx != 0) // if returns to origin or it is not facing north at the end
            return true;
        return false;
    }
}