class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0)
            return true;
        int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
        int x = 0, y=0, i =0;
        for(int j=0;j<instructions.length();j++)
        {
            char ch = instructions.charAt(j);
            if(ch == 'L')
            {
                i = (i+1)%4;
                
            }else if(ch == 'R')
            {
                i = (i+3)%4;   
            }else if(ch == 'G')
            {
                x += directions[i][0] ;
                y += directions[i][1] ;
            }
        }
        return  (i!= 0) || (x == 0 && y == 0); 
    }
}

//Time complexity: O(n)
//Space Complexity : O(1)