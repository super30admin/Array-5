// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Perform one set of instructions, if we reach the origin or if we are facing any other direction than 
/// North we can bind the robot in a circle
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y= 0;
        int dir = 0; //indicates north
        for(int i=0;i<instructions.length();i++){
            int inst = instructions.charAt(i);
            if(inst == 'G'){
                if(dir==0)
                    y = y+1;
                else if(dir ==1){//west
                    x=x-1;
                }
                else if(dir==2){//south
                    y=y-1;
                }
                else{//east
                    x=x+1;
                }
            }
            else if(inst == 'L'){
                dir = (dir+1)%4;
            }
            else{
                dir = (4+dir-1)%4;
            }
            System.out.println(x+" "+y+"->"+dir);
        }
        if(dir!=0 || (x==0 && y==0)){
            return true;
        }
        return false;
    }
}