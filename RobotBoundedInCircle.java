// TC : Traverse only once through Array -> O(N) -- length of String
// SC : O(1) No extra space is used.
// Approach : iterate through the array and use the idx to determine which side the robot is facing and moving forward.
//   Correctly handle the right and left turns .
//   In the end after completing all steps check if the robot is not pointing N or when x,y are at 0,0
// If thats the case then we can reach the starting point

class Solution {
    public boolean isRobotBounded(String instructions) {
        // directions N W S E
        int[][] dirs = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int n = instructions.length();
        int idx = 0;
        int x=0, y=0;
        for (int i = 0; i < n; ++i) {

            if(instructions.charAt(i) == 'G'){
                x += dirs[idx][0];
                y += dirs[idx][1];
            } else if(instructions.charAt(i) == 'L'){
                idx = (idx+1)%4;
            } else{
                idx = (idx+3)%4;
            }
        }
        if(idx != 0 || (x == 0 && y == 0)) return true;
        return false;
    }
}
