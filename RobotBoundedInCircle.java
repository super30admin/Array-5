// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public boolean isRobotBounded(String instructions) {
       int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int x=0;
        int y=0;
        
        int i=0;
        
        for(char c : instructions.toCharArray()){
            if(c=='L'){
                i = (i+3) % 4;
            }else if(c=='R'){
                i = (i+1) % 4;
            }else{
                x = x + directions[i][0];
                y = y + directions[i][1];
            }
        }
        if ((x==0 && y==0) || i!=0)
            return true;
        return false;
    }
}