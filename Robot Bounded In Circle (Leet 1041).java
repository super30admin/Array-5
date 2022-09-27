// Time: O(n)
// Space: O(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int ind = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'L'){
                ind = (ind+3)%4;
            }else if(c == 'R'){
                ind = (ind+1)%4;
            }else{
                x = x + dirs[ind][0];
                y = y + dirs[ind][1];
            }
            
        }
        return (ind != 0) || (x == 0 && y == 0);
    }
}
