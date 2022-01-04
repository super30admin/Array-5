class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions.length() == 0) return true;
        
        int [][] dirs = {{0,1}, {-1,0}, {0,-1}, {1, 0}}; // N, W, S, E
        int x = 0;
        int y = 0; 
        int i = 0; // dir arr index
        
        for(int j = 0; j < instructions.length(); j++){
            char c = instructions.charAt(j);
            if(c == 'L'){
                i = (i + 1) % 4; 
            }else if(c == 'R'){
                i = (i+3) % 4;
            }else{
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        return (i != 0 || ( x == 0 && y == 0));
 
    }
}

//TC: O(n)
//SC: O(1)
