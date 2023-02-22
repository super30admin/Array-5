//https://leetcode.com/problems/robot-bounded-in-circle
//TC : o(n)
//SC : o(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int l=instructions.length();
        int dir = 0;
        int x=0; int y=0;
        for(int i=0;i<l;i++){
            char c = instructions.charAt(i);
            switch(c){
                case 'L':
                    dir = (dir+1)%4;
                    break;
                case 'R':
                    dir = (dir+3)%4;
                    break;
                default:
                    x = x + dirs[dir][0];
                    y = y + dirs[dir][1];
            }
        }
        return (x==0 && y==0) || dir != 0;
    }
}
