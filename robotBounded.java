// tc : O(n)
// sc : O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        int i = 0, x = 0, y = 0 ;
        int[][] dirs = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        for(int j =0; j<instructions.length() ; j++){
            if(instructions.charAt(j) == 'R')
                i = (i+1)%4;
            else if(instructions.charAt(j) == 'L')
                i = (i+3)%4;
            else{
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        return (x==0 && y==0) || i>0;
    }
}
