/*
The time compleixty is O(N) where N is the length of instructions and the space complexity is O(1).

Here, the intuition is to see that at the end of executing all the instrctions whether our robot reached origin or facing other direction
than North. If this happens we can say that after executing infinite number of times our robot will be contained in a circle.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public boolean isRobotBounded(String instructions) {

        //This is the direction array to check in which direction we are facing
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        int x = 0; int y = 0; int id = 0;

        for(int i=0;i<instructions.length();i++){

            //If instruction is G we move one step in our current direction.
            if(instructions.charAt(i)=='G'){
                x+= dir[id][0];
                y+=dir[id][1];
            }//If L then from our current direction we turn three times to face L
            else if(instructions.charAt(i)=='L'){
                id = (id+3)%4;
            }//If R we turn only once.
            else{
                id = (id+1)%4;
            }
        }

        return (x==0 && y==0) || id!=0;
    }
}