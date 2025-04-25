
//TC-O(L) length of instructions. SC-O(1)
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
    int [][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}}; //north = 0, east = 1, south = 2, west = 3
    int x = 0, y = 0;//initial position
    int idx=0;//north
        for (char i : instructions.toCharArray()) {
        if (i == 'L')
            idx = (idx + 3) % 4;
        else if (i == 'R')
            idx = (idx + 1) % 4;
        else {
            x += dirs[idx][0];
            y += dirs[idx][1];
        }
    }
    // after one cycle:
    // robot returns into initial position
    // or robot doesn't face north
         return (x == 0 && y == 0) || (idx != 0);
}
}
