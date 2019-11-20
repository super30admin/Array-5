//Time Complexity:O(N)
//Space Complexity:O(1)
//Approach - Create 4 directions , beacuse the robot is bound to move in any of the four directions based on the given instruction. i+1 for left and i+3 for right is simply based on directions, turning 1 step left is equivalent to turning 3 steps right and vice versa. This is used to calculate the i value, which will be used to calculate the x and y value from the direction array. At the end if both x and y are 0 or if i is greater than 0, then the robot is bounded in a circle. Else it is not. 
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0;
        int y=0;
        int i=0;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int s=0;s<instructions.length();s++){
            if(instructions.charAt(s)=='L'){
                i=(i+1)%4;
            }
            else if(instructions.charAt(s)=='R'){
                i=(i+3)%4;
            }
            else{
                x+=dir[i][0];
                y+=dir[i][1];
            }
        }
        return x==0 && y==0 || i>0;
    }
}