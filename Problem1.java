/*
Robot Bounded In Circle
approach: we can see after executing the instruction one time, if the dir is facing other than north then robot will be able
to reach origin
time: O(n)
space: O(1)
 */
public class Problem1 {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int n = instructions.length();
        int x = 0, y = 0;

        for (int i=0;i<n;i++) {
            char c = instructions.charAt(i);
            if (c=='G') {
                x = x+dirs[dir][0];
                y = y+dirs[dir][1];
            } else if (c=='R') {
                dir = (dir+1)%4;
            } else if (c=='L') {
                dir = (dir+3)%4;
            }
        }
        if (dir!=0 || (x==0 && y==0)) return true;

        return false;
    }
}
