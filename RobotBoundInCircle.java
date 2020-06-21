// 1041.
// time - O(length of instructions)
// space - constant
class Solution {
    public boolean isRobotBounded(String instructions) {
        //edge
        if(instructions == null || instructions.length() == 0)
        {
            return true; //robot already in origin
        }
        
        //after proceesing instructions once, if robot reaches origin return true
        //after proceesing instructions once, if robot doesn't faces north direction, then it will reach origin again as it falls into a circle and is bound to return to origin
        
        //start from north -> turn left to reach west -> turn left to reach south -> turn left to reach east
        //north = dirs[0], west = dirs[1], south = dirs[2], east = dirs[3]
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; 
        int initialX = 0; //initially robot is at (0,0)
        int initialY = 0;
        int initialDir = 0; //initially robot faces north -> dirs[0]
        
        for(char instruction : instructions.toCharArray())
        {
            //if bot turns left from north, direction changes to west i.e 0 to 1
            //if bot turns left from west, direction changes to south i.e 1 to 2
            //if bot turns left from south, direction changes to east i.e 2 to 3
            //if bot turns left from east, direction changes to north i.e 3 to 0
            // thus dir becomes (dir + 1) % 4 in case of left and (dir + 3) % 4 in case of right
            // if current instruction is G, then bot pos changes by current pos + dirs[current dir]
            if(instruction == 'L')
            {
                initialDir = (initialDir + 1) % 4; 
            }
            else if(instruction == 'R')
            {
                initialDir = (initialDir + 3) % 4;
            }
            else //instruction == 'G'
            {
                initialX += dirs[initialDir][0];
                initialY += dirs[initialDir][1];
            }
        }
        
        return ((initialX == 0 && initialY == 0) || initialDir != 0) ? true : false;
    }
}
