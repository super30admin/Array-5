class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x =0; int y=0;
        int idx=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<n;j++){
                char c = instructions.charAt(j);
                if(c=='G'){
                    x+=dirs[idx][0];
                    y+=dirs[idx][1];
                }else if(c=='R'){
                    idx=(idx+1)%4;
                }else{
                    idx=(idx+3)%4;
                }
            }
            if(x==0&&y==0) return true;
        }
        return false;
    }
}