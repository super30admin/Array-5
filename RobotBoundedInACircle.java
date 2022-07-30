//time: O(N) | Space: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int i=0;
        int x=0;
        int y=0;
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        for(int j=0;j<instructions.length();j++) {
            char c = instructions.charAt(j);
            if(c=='L') i=(i+1)%4;
            if(c == 'R') i = (i+3)%4;
            if(c == 'G') {
                x+=dirs[i][0];
                y+=dirs[i][1];
            }
        }
        // robot still facing normal after first execution of full instructions, it never gonna come back, so false
        // if it goes back to origin, then true
        return (x==0 && y==0) || (i!= 0);
    }
}