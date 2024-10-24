class Solution {
    public boolean isRobotBounded(String instructions) {

        // Define directions
        //                    north, east, south, west
        int[][] directions = {{0,1},{1,0},{0,-1}, {-1,0}};
        int dirIndex = 0; // to keep track of our final direction aftere a loop
        int x = 0; int y = 0; // initial starting point

        for(char c : instructions.toCharArray()){
            if (c == 'G'){
                x += directions[dirIndex][0];
                y += directions[dirIndex][1];
            }
            // update direction as we go along the instruction

            // left i.e. west... 
            else if(c == 'L'){
                dirIndex = (dirIndex + 3) % 4;
            }
            else if(c == 'R'){
                dirIndex = (dirIndex + 1) % 4;
            }

        }

        if( (x == 0 && y == 0) || (dirIndex != 0)){
            return true;
        }
        
        return false;
    }
}
