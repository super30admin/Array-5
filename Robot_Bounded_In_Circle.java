class Solution {
    public boolean isRobotBounded(String instructions) {
                                    //North //East   //South //West
        int [][]dirs = new int [][]{{0,1},   {1,0},  {0,-1}, {-1,0}};
        int index = 0;
        int x = 0;
        int y=0;
        //Maximum 4 times
      //  for(int k =0; k<4;k++) {
          for(int i =0; i<instructions.length();i++) {
            char c = instructions.charAt(i);
            if(c == 'G') {
                x = x+dirs[index][0];
                y = y+ dirs[index][1];
            } else if(c == 'L') {
                index = (index+3)%4;
            } else {
                index = (index+1)%4;
            }
          }
          if((x == 0 && y == 0) || index != 0) {
            return true;
        }
    //}
        
        return false;
    }
}