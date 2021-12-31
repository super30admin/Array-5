// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isRobotBounded(String instructions) {
        int [][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int x = 0, y = 0;//Initial position is in the center 
        //facing east
        int dir = 0;
        for(char ch:instructions.toCharArray()){
            if(ch == 'L')
                dir = ( dir + 1 ) % 4;
            else if(ch == 'R')
                dir = ( dir + 3 ) % 4;
            else{
                x += directions[dir][0];
                y += directions[dir][1];}
        }
        if (x == 0 && y == 0)//if the robot is at starting position it is bound to be in a circle with time
            return true;
        if(dir != 0)// if dir is not 0 then it's direction has changed since initial and therefore it is bound in a circle
            return true;
        else
            return false;
    }
}

