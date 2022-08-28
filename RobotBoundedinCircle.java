//TC - O(n)
//SC - O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int [][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0} };
        int x = 0; int y = 0;
        int i = 0;
        for(int j = 0; j < instructions.length(); j++){
            char dir = instructions.charAt(j);
            if(dir == 'R'){
                i =  (i + 3) % 4;
            }else if(dir == 'L'){
                i = (i + 1) % 4;
            }else{
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        return (x == 0 && y== 0) || i != 0;
    }
}
