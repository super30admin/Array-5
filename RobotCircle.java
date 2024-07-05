//Time Complexity : O(n), n is the length of instructions array
//Space Complexity : O(1)
//Did this code run successfully on leetcode: Yes
//Have you faced any problem while coding: No
class RobotCircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0; 
        int y = 0;
        int idx = 0; // pointer that determines the direction
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //N E W S
        for(int i = 0; i < 4; i++) {
            for(int j =0; j < instructions.length(); j++) {
                char c = instructions.charAt(j);
                if(c == 'G') {
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                } else if(c == 'R') {
                    idx = (idx+1)%4;
                    
                } else if (c == 'L') {
                    idx = (idx+3)%4;
                }
                
            }
            if(x == 0 && y == 0) return true;
            
        }
        return false;
    }
}