// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int x = 0; int y = 0;
        int idx = 0;
        for(int i = 0; i < instructions.length(); i++){
            char ch = instructions.charAt(i);
            if(ch == 'G'){
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
            else if(ch == 'L'){
                idx = (idx+1)%4;
            }
            else{
                idx = (idx+3)%4;
            }
        }
        return (x == 0 && y == 0) || (idx > 0);
    }
}