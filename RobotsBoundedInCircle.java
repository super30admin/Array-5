class RobotsBoundedInCircle {
    public static void main(String args[]) {
        System.out.println(isRobotBounded("G"));
    }
    public static boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0,1},{1,0}, {0,-1}, {-1,0}};
        int x = 0; int y = 0;
        int i = 0;
        for(int j = 0; j < 4; j++) {
            for(int k = 0; k < instructions.length(); k++) {
                char c = instructions.charAt(k);
                if(c == 'G') {
                    x += dirs[i][0];
                    y += dirs[i][1];
                }
                else if (c == 'L') {
                    i = (i+3)%4;
                }
                else {
                    i = (i + 1)%4;
                }
            }
        }
        return x == 0 && y == 0;
    }
}