// Time Complexity : O(n)  where n is the length of instructions string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We assign values to each directions and create directions array
// We iterate over the instructions array
// If we encounter L we move right 3 times clock wise
// If we encounter R we move once right
// After the instuctions are over, if we are in same position return true
// If we not in the same position and direction is north return false
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions ={
            {0, 1}, //north
            {1, 0}, //east
            {0, -1}, //south
            {-1, 0} //west
        };
        int dir = 0;
        int x = 0, y = 0;
        for(char c: instructions.toCharArray()){
            if(c == 'L'){
                dir = (dir + 3) % 4;
            }
            else if(c == 'R'){
                dir = (dir + 1) % 4;
            }
            else{ //Go
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        return ((x == 0) && ( y== 0)) || (dir != 0);
    }
}