// Time : O(4n) 
// Space :
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x =0,y=0; // robot origin
        // Initially if robot is at North direction
        int idx=0;
        // Move in anticlockwise or clockwise
                                // N  W      S     E
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};

        // we have 4 planes/4 directions
        // In these directions we execute the instructions
        // For every 1 direction we execute the set of instructions and check if x and y reaches the origin.
        // So total of 4 * (len of instructions)
        for(int i=0;i<4;i++){
            for(Character ch: instructions.toCharArray()){
                if(ch == 'G'){
                    // move forward
                    // whatever the dirs are just add
                    x+=dirs[idx][0];
                    y+=dirs[idx][1]; 
                }else if (ch == 'L'){
                    // Based on the direction - idx
                    idx = (idx + 1) %4; // to avoid out of bound
                } else if (ch == 'R'){
                    // Based on the direction - idx
                    idx = (idx+3) %4; // to avoid out of bound
                }
            }
            // If any point in time it reaches to origin then isRobotBounded
            if( x == 0 && y ==0) return true;
        }
        return false;
    }
}

// Approach : Optimized. After executing instructions for one direction if x and y reaching 1 or not in the same direction
// Time : O(n) 
// Space :
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x =0,y=0; // robot origin
        // Initially if robot is at North direction
        int idx=0;
        // Move in anticlockwise or clockwise
                                // N  W      S     E
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};

        // we have 4 planes/4 directions
        // In these directions we execute the instructions
        // For every 1 direction we execute the set of instructions and check if x and y reaches the origin.
        // So total of 4 * (len of instructions)
        for(int i=0;i<4;i++){
            for(Character ch: instructions.toCharArray()){
                if(ch == 'G'){
                    // move forward
                    // whatever the dirs are just add
                    x+=dirs[idx][0];
                    y+=dirs[idx][1]; 
                }else if (ch == 'L'){
                    // Based on the direction - idx
                    idx = (idx + 1) %4; // to avoid out of bound
                } else if (ch == 'R'){
                    // Based on the direction - idx
                    idx = (idx+3) %4; // to avoid out of bound
                }
            }
            // If any point in time it reaches to origin then isRobotBounded
            // Or direction is not same as starting direction then it will come back to origin
            if((x == 0 && y ==0) || idx!=0) return true;
        }
        return false;
    }
}