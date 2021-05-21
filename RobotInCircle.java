class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};//U R D L
        
        int x = 0;
        int y = 0;
        
        int i = 0;
        
        for(char ch: instructions.toCharArray()){
            if(ch == 'R'){
                i = (i + 1) % 4;
            }else if(ch == 'L'){
                i = (i+3) % 4;
            }else{
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        
        return x == 0 && y == 0 || i > 0;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)