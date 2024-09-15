//TC - O(N)
//SC - O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) return true;
        //                 N      W      S     E
        int [][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int x = 0;
        int y = 0;
        int i = 0;
        for(int k = 0; k < instructions.length(); k++){
            char c = instructions.charAt(k);
            if(c == 'L'){
                i = (i + 1) % 4;
            }
            else if(c == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x += dirs[i][0];
                y += dirs[i][1];
            }
        }
        if((x == 0 && y == 0)|| i != 0){
            return true;
        }
        return false;
     }
}