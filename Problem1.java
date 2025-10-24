
//Time Complexity: O(N)
//Space Complexity: O(1)

//Did this code successfully run on Leetcode : Yes


//We simulate the robot's movement based on the given instructions. We keep track of its position and direction.
//After executing the instructions four times, if the robot returns to the origin, it is bounded in a circle.
//if the instruction in G update the position
//if the instruction is L or R update the direction accordingly
//for L the idx is incremented by 1 and for R it is decremented by 1
//We use modulo 4 to cycle through the directions array

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0,idx=0;
                                     //N, W, S, E
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, { 0,-1}, {1, 0}};
        for(int i=0;i<4;i++){
            for(char c:instructions.toCharArray()){
                if(c=='G'){
                    x+=dirs[idx][0];
                    y+=dirs[idx][1];
                }else if(c=='L'){
                    idx=(idx+1)%4;   
                }else if(c=='R')
                //we use +3 instead of -1 to avoid negative modulus
                    idx=(idx+3)%4;
            }
            if(x==0&&y==0)
                return true;
        }
        return false;
    }
}