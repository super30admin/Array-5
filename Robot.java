//Using dirs array to track movement of robot

class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0)
            return true;
        
        //create dirs array in either clockwise or anticlockwise direction as we have to move either left or right so it becomes easier to access them
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};  // N E S W
        
        //i is a pointer used to traverse dirs array
        int i = 0;
        int x = 0, y = 0;
        
        for(int j = 0; j < instructions.length(); j++){
            char ch = instructions.charAt(j);
            if(ch == 'L')
                i = (i + 1) % 4;
            else if(ch == 'R')
                i = (i + 3) % 4;
            else{
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        //do % 4 as when you add dirs to x & y, it may be greater than 4 and since dirs array has only 4 elements, we have to bound it to 4 so that we can access dirs array left, right
        
        return x == 0 && y == 0 || (i != 0);
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)