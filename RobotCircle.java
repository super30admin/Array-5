//Time - O(n)
//Space - O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs =  new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x =0;
        int y=0;
        int dir_idx =0;
        for(int i=0; i< instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c=='G'){
                x += dirs[dir_idx][0];
                y+= dirs[dir_idx][1];
            }else if(c == 'L'){
                dir_idx = (dir_idx+3)%4;
            }else if(c == 'R'){
                dir_idx = (dir_idx+1)%4;
            }
        }
        return (x==0 && y==0)|| dir_idx !=0;
    }
}