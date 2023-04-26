//TC: O(n)
//SC: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        //null
        if(instructions == null) return false;
                                //N     //E     //S     //W
        int [][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int n = instructions.length();
        int x = 0;
        int y= 0;
        int i = 0; //index on directions
        
        for(int j=0;j<n;j++){
            char c = instructions.charAt(j);
            if(c == 'G'){
                x += directions[i][0];
                y += directions[i][1];
            }else if(c == 'R'){
               i = (i+1)%4;
            }else {
                i=(i+3)%4;
            }
        }
        return (x==0 && y==0) || i!=0;
    }
}
