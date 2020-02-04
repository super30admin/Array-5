TC: O(n)
SC: O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Robot Bounded In Circle.
Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Robot Bounded In Circle.

Approach: The approach is that if the final position after following the instructions is same as initial position or if the 
direction after the instruction is anything other than up , it means the robot is bounded.


class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        int x=1;
        int y=1;
        
        int i=0;
        for(char ch : instructions.toCharArray()){
            
            if(ch=='L'){
                i=(i+3)%4;
            }else if(ch =='R'){
                i=(i+1)%4;
            }else {
                x+= dirs[i][0];
                y+= dirs[i][1];
            }
            
        }
        
        return x==1 && y==1 || i>0;
    }
}
