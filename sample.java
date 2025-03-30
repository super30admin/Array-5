class sample{
    /********************PROBLEM-1*****************/
    //TC:0(N)
//SC:0(1)
    class Solution {
        public boolean isRobotBounded(String instructions) {
            if(instructions==null|| instructions.length()==0){
                return true;
            }
            int[][] dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};// N W S E
            int x=0,y=0,j=0;
            for(int i=0;i<instructions.length();i++){
                char each=instructions.charAt(i);
                if(each=='G'){
                    x=x+dirs[j][0];
                    y=y+dirs[j][1];
                }else if(each=='L'){
                    j=(j+1)%4;

                }else{
                    j=(j+3)%4;
                }
            }
            return ((x==0 && y==0)|| j!=0);
        }
    }

    //TC:0(N)
//SC:0(1)
    class Solution {
        public boolean isRobotBounded(String instructions) {
            if(instructions==null|| instructions.length()==0){
                return true;
            }
            int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};// N E S W
            int x=0,y=0,j=0;
            for(int i=0;i<instructions.length();i++){
                char each=instructions.charAt(i);
                if(each=='G'){
                    x=x+dirs[j][0];
                    y=y+dirs[j][1];
                }else if(each=='L'){
                    j=(j+3)%4;

                }else{
                    j=(j+1)%4;
                }
            }
            return ((x==0 && y==0)|| j!=0);
        }
    }
    /********************PROBLEM-2*****************/

}