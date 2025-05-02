
//TC: O(n)
//SC: O(1)
class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int n=instructions.length();
        //                       n        w     s      e
        int[][] dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        //north
        int idx=0;
        int x=0;
        int y=0;

        for(int i=0;i<n;i++){
            if(instructions.charAt(i)=='L'){
                idx=(idx+1)%4;
            }else if(instructions.charAt(i)=='R'){
                idx=(idx+3)%4;
            }else{
                x=x+dirs[idx][0];
                y=y+dirs[idx][1];
            }
        }
        
        if((x==0 && y==0) || idx!=0){
            return true;
        }
        return false;
    }
}

/*
class Solution {
    public boolean isRobotBounded(String instructions) {
        int n=instructions.length();
        //                       n        w     s      e
        int[][] dirs=new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        //direction index
        int idx=0;

        int x=0;
        int y=0;
        for(int j=0;j<4;j++){
            for(int i=0;i<n;i++){
                if(instructions.charAt(i)=='L'){
                    //c=c-1;
                    idx=(idx+1)%4;
                }else if(instructions.charAt(i)=='R'){
                    //c=c+1;
                    idx=(idx+3)%4;
                }else{
                    x=x+dirs[idx][0];
                    y=y+dirs[idx][1];
                }
            }
        }
        
        
        if((x==0 && y==0) ){
            return true;
        }
        return false;
    }
}
*/