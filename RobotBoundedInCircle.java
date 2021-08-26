package Array5;

public class RobotBoundedInCircle {

}//TC : o(n) where n is length of the string
//SC : o(1)
//Approach : Go over instruction as many times untill it reaches origin
//to go to diff directions use (i+3)%4 
class Solution {
  public boolean isRobotBounded(String instructions) {
      //null check
      if(instructions == null || instructions.length() == 0) return false;
      
      //dirs array    n, e, s, w
      int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
      //initially at origin
      int x = 0;
      int y = 0;
      int i=0;
      for(int k=0; k<instructions.length(); k++){
          char c = instructions.charAt(k);
          if(c == 'L'){
              i = (i+3)%4;
          }else if(c == 'R'){
              i = (i+1)%4;
          }else if(c == 'G'){
              x+= dirs[i][0];
              y+= dirs[i][1];
          }
      }
      //if it is at origin OR if facing towards north it will surely reach origin
      return (x==0 && y==0) || (i!=0);
  }
}
