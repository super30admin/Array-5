//idea is to move 4 rounds of instrictions or 1 round if it comes back to north again it is false if it ends up in diff
// dir its true

class Solution {
    public boolean isRobotBounded(String instructions) {
                                //. N.     E.      S.      W
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
        int idx = 0;
        int x = 0, y = 0;

       // for(int i =0; i < 4; i++){
            for(char c : instructions.toCharArray()){
                if(c == 'G'){//MOVING 1 step in present dir
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                }else if(c == 'R'){// it will east if moving to right 
                    idx = (idx + 1)%4;
                }else if(c == 'L'){
                    idx = (idx + 3)%4;
                }
            }
            //if(x == 0 && y == 0) return true;
            if(x == 0 && y == 0 || idx != 0) return true;
     //   }

        return false;
    }
}