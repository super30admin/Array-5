class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int idx = 2;
        int x=0, y=0;


      //  for(int i=0;i<4;i++){
            for(char c: instructions.toCharArray()){
                if(c == 'G'){
                    x+=dirs[idx][0];
                    y+=dirs[idx][1];
                }else if(c == 'L'){
                    idx = (idx+1)%4;
                }else if(c == 'R'){
                    idx = (idx+3)%4;
                }
            }

            if((x==0 && y==0) || idx!=2) return true;
    //    }
        return false;
    }
}