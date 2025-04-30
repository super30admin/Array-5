//The approach here is that if after completing the first set of instructions, if the pointer is not at origin or if it is facing north, then it never be in a circle, even after many repetitions of instructions
//Time Complexity: O(n) where n is the length of the instructions
//Space Complexity: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}}; //n w s e anti-clockwise direction
        int idx = 0;
        int x = 0; int y = 0;
        for(int j = 0; j < instructions.length(); j++){
            char ch = instructions.charAt(j);
            if(ch == 'G'){
                //new x and y
                x += dirs[idx][0]; //0+0
                y += dirs[idx][1]; //0+1
            } else if(ch == 'R'){
                idx = (idx+1)%4;
            } else {
                idx = (idx + 3)%4;
            }
        }
        if((x == 0 && y == 0) || idx != 0) return true;
        return false;
    }
}