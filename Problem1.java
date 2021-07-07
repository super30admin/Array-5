// Time Complexity - O(n) where n is the length of instructions
// Space Complexity - O(1)
// This Solution worked on Leetcode


class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() ==0)
            return true;
        int x=0;
        int y=0;
        int i=0;
                        //N   E     S      W        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        // It is clockwise so if the direction is north and we turn left we would be getting into west which is 3 away from N in the directions array. 
        for(int j=0;j < instructions.length();j++){
            char c = instructions.charAt(j);
            if(c =='L'){
                i=(i+3)%4;
            }
            else if(c =='R'){
                i=(i+1)%4;
            }
            else{
                x+=dirs[i][0];
                y+=dirs[i][1];
            }
        }
        return (x==0 && y==0) || i != 0;
    }
}
