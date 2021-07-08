// Time Complexity : O(n), instruction length
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// main idea is since same instruction is repeated and allowed moves as 'G', 'L' or 'R', if robot changes direction it would eventually return to (0,0)
// process instruction set once and check if dir has changed from initial north, or base case it hasn't moved at all, pos is (0,0) 

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int facingDirIdx = 0;
        int x=0, y=0;
        
        for(char curIns : instructions.toCharArray()){
            if(curIns=='G'){
                x += dirs[facingDirIdx][0];
                y += dirs[facingDirIdx][1];
            }
            else if(curIns=='R'){
                facingDirIdx += 1;
                facingDirIdx = facingDirIdx%4;
            }
            else{
                facingDirIdx += 3;
                facingDirIdx = facingDirIdx%4;
            } 
        }
        
        if((x==0 && y==0) || facingDirIdx!=0)
            return true;
        
        else return false;
    }
}