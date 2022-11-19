class Solution {//tc-o(n) sc-o(1)
    public boolean isRobotBounded(String instructions) {
       if(instructions == null) return false;
       int[][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};//N, E, S, W
       int x=0;
       int y=0;
       int i=0;
       for(int k=0;k<instructions.length();k++)
       {
           char c = instructions.charAt(k);
           if(c == 'G')
           {
               x+= dirs[i][0];
               y+= dirs[i][1];
           }
           else if(c == 'L')
           {
               i = (i+3)%4;
           }
           else{///right
               i = (i+1)%4;
           }
       }
       return (x==0 && y==0) || (i!=0);
  
    }
}