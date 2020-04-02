//Time Complexity: O(n)
//Time Complexity: O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0, y=0;   //coordinates
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int i = 0;
        for(int j=0; j<instructions.length(); j++){
            char c = instructions.charAt(j);
            //for R; if(i+1)%4 -> index 0
            //for L; if(i+3)%4 -> index 0
            if(c == 'R') i=(i+1)%4;
            else if(c == 'L') i=(i+3)%4;
            else{
                //increment in x and y coordinate
                x+= dirs[i][0];
                y+= dirs[i][1];
            }
        }
        //return if reached to origin or faces towards north
        return x==0 && y==0 || i>0;
    }
}