// Time Complexity : O(n).
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Approach : We store directions in dirs array in clockwise direction. When we come across G, we move x and y coordinates in it's current direction. If L or R, we
// change the direction by taking 3 steps or 1 step forward based on clockwise or anti clockwise. Finally, we check if we reached start point or idx is facing any direction
// other than initial position direction and return true or false.

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //North, East, South, West
        int idx = 0;
        int x = 0;
        int y = 0;
        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                x += dirs[idx][0]; //move x coordinate
                y += dirs[idx][1]; //move y coordinate
            } else if(ch == 'L'){
                idx = (idx+3)%4; //change direction
            }else{
                idx = (idx+1)%4; //change direction
            }
        }
        if((x==0 && y==0) || idx != 0){ //if reached start point or idx is facing any direction other than initial position direction
            return true;
        }
        return false;
    }
}