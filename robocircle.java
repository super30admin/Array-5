TC:O(n) - length of the instructions string
SC:O(1)
Successfully run in leetcode
use dthe directions array to move to the 4 directions in the clockwise order.It is clear that after the first
iteration if the robo still faces north then it will never have a circular motion and hence false is returned.

class Solution {
    int [][]dirs;
    public boolean isRobotBounded(String instructions) {
        dirs = new int [][] {{0,1},{1,0},{0,-1},{-1,0}};
        int x =0,y=0;
        int j=0;
        for(int i = 0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                x = x + dirs[j][0];
                y = y + dirs[j][1];
            }
            else if(c == 'L'){
                j = (j+3)%4;
            }
            else{
                j = (j+1)%4;
            }
        }
        return (x==0 && y==0) || j!=0;
    }
}