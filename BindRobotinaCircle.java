//Time Complexity: O(N)
//Space Complexity: O(1)
//Define the 4 directions that the robot can travel in d
//iterate over the given instuction string character by character and check if 'R','L' or 'G'.
//If R then calculate the i of the coordinate as the robot should turn to Right direction and i+1 and take % 4 as we are restricting the directions d from 0-3.
//Else if L then calculate i of the coordinate as the robot should turn to Left (Left means 3 times Right or vice-versa) direction hence i+3 and take % 4
//else its G meaning the bot needs to move 1 unit forward in the direction it is facing hence calculate the x and y coordinates.
//Return if x and y is 0 or if i>0 then it is true else it is false 
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0;
        int y=0;
        int i=0;
        int[][] d={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int j = 0; j<instructions.length(); ++j)
        {
            if(instructions.charAt(j) =='R')
            {
                i=(i+1)%4;
            }
            else if(instructions.charAt(j) =='L')
            {
                i=(i+3)%4;
            }
            else
            {
                x+=d[i][0];
                y+=d[i][1];
                
            }
        }
        return x==0 && y==0 || i>0;
    }
}