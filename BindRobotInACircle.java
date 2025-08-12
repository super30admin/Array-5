//time complexity- O(n)
//space complexity- O(1)
public class BindRobotInACircle {
    static boolean isRobotBounded(String instructions) {
        int len = instructions.length();
        int[][] dir = {{0, 1}, {-1, 0},{0,-1}, {1,0}};

        int x = 0;
        int y = 0;
        int pos = 0;
        for(int j = 0; j < len; j++) {
            char c = instructions.charAt(j);
            if(c == 'G') {
                x += dir[pos][0];
                y += dir[pos][1];
            } else if(c == 'R') {
                pos = (pos + 3) % 4;
            } else {
                pos = (pos + 1) % 4;
            }
        }
        if(x == 0 && y == 0) return true;
        if(pos != 0) return true;
        return false;
    }

    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println("Instructions: "+ instructions);
        System.out.println("Will robot return? ->" + isRobotBounded(instructions));
    }
}
