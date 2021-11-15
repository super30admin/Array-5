//TC: O(n), where n is the length of the intruction string
//SC: O(1)
//running on leetcode: yes
class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length()==0) return true;
        int i=0; //direction indicator
        int x=0, y=0;//x and y coordinates for the robot
        //directions: north, east, south, west
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int j=0; j<instructions.length(); j++) {
            char c=instructions.charAt(j);
            if(c=='L') {
                i = (i+3)%4;
            }
            else if(c=='R'){
                i=(i+1)%4;
            }
            else {
                x=x+dirs[i][0];
                y=y+dirs[i][1];
            }
        }
        return (x==0 && y==0) || (i!=0);
        
    }
}
