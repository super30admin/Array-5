class Solution {
    public boolean isRobotBounded(String instructions) {
        //o(n) time constant space
        int[][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int x = 0; int y = 0;
        int j = 0;
        for(int i = 0; i < instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'R'){
                j = (j+3) % 4;
            } else if(c == 'L'){
                j = (j + 1) % 4;
            } else {
                x+= dirs[j][0];
                y+= dirs[j][1];
            }
        }
        return x == 0 && y == 0 || (j != 0);
    }
}