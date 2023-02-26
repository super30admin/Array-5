/*
In 4 repetition of the complete instruction , if the robot is back at the origin then its in a circle, otherwise not
Time: O(n)
Space : O(1)
*/
class Solution {
    public boolean isRobotBounded(String instructions) {
                //       S     , w   ,   N    , E 
        int[][] dirs= new int[][]{ {0,-1} ,{-1,0} ,{0,1},{1,0} }; // each element array represent the coordinates when added , result in moving in that direction

        int idx = 2 ; // initially facing N 

        int[] coords = new int[]{0,0};
        for(int count =0; count <4 ; count++){ // will repeat the instructions 4 times
        for(int i=0;i<instructions.length();i++){
            char ins = instructions.charAt(i);
            if(ins == 'L'){  
                idx-- ;
                if(idx <0){
                    idx = 4 - Math.abs(idx);
                }
            }
            else if(ins == 'R'){
                idx++;
                if(idx > 3){
                    idx  = idx % 4;
                }
            }
            else { // it must be G
            coords[0]+=dirs[idx][0];
            coords[1]+=dirs[idx][1];
            }
        }
        }
        
        return (coords[0] == 0 && coords[1] ==0);
    }
}