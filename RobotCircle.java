// Time Complexity : O(4*n), 
// Space Complexity :  O(1) 
// Did this code successfully run on Leetcode : yes
//Approach : max steps required to complete circle is 4, if it didn't reach in 4 iterations it will not reach origin

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}}; // N E S W
        int n = instructions.length();
        int x = 0; int y = 0; //starting position
        int idx = 0; //direction
        for(int k = 0 ; k < 4 ; k++){ // max steps it will take to complete the circle
            for(int i = 0 ; i < n ; i++){
                char c = instructions.charAt(i);

                if(c == 'G'){
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                }
                else if(c == 'L'){
                    idx = (idx+3)%4;
                }
                else{
                    idx = (idx+1)%4;
                }
            }
            if(x == 0 && y == 0) return true;
        }

        return false;
    }
}
// Time Complexity : O(n), 
// Space Complexity :  O(1) 
// Did this code successfully run on Leetcode : yes
//Approach : if after first iteration if the direction is not north, it will reach origin

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}}; // N E S W
        int n = instructions.length();
        int x = 0; int y = 0; //starting position
        int idx = 0; //direction

        for(int i = 0 ; i < n ; i++){
            char c = instructions.charAt(i);

            if(c == 'G'){
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
            else if(c == 'L'){
                idx = (idx+3)%4;
            }
            else{
                idx = (idx+1)%4;
            }
        }

        if(x == 0 && y == 0 || idx != 0) return true;
        

        return false;
    }
}