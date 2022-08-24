//****170.1041.ROBOT BOUNDED IN A CIRCLE*****
//Time complexity: o(n);
//Space complexity:o(1);

class Solution {
    public boolean isRobotBounded(String instructions) {
                                // N     w      S       E
        int[][] dirs=new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        
        //Initial position of robot
        int x=0; int y=0;
        
        //Robot is pointing in the North Direction
        int i=0;
        
        for(int j=0;j<instructions.length();j++)
        {
            char c=instructions.charAt(j);
            if(c=='L')
            {
                i=(i+1) %4;
            }
            else if(c=='R')
            {
                i=(i+3)%4;
            }
            else
            {
                x+=dirs[i][0];
                y+=dirs[i][1];
            }
        }
        
        return (x==0 && y==0) || i!=0;
        
    }
}
